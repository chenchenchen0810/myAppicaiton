package com.example.john.myapplication;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.squareup.leakcanary.LeakCanary;

import java.io.File;

/**
 * Created by john on 2018/3/22.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFileDir();
        initImageLoader(getApplicationContext());
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    private void initFileDir(){
        //新建一个File，传入文件夹目录
        File appFile = new File(AppConfig.APP_Path);
        //判断文件夹是否存在，不存在则创建
        if(!appFile.exists()){
            appFile.mkdir();
            /**
             * .mkdir()与mkdirs()的区别：
             mkdir（）是只能创建一级目录（文件夹），如果这一级目录的上面还有没有创建的目录（文件夹），那么程序会报错。
             mkdirs（）是可以创建多级目录（文件夹），它是把所有没有的目录（文件夹）都给创建出来。
             所以开发中常用mkdirs（）来创建目录（文件夹）。
             */
        }

        File imgFile = new File(AppConfig.DIR_IMG);
        if(!imgFile.exists()){
            imgFile.mkdir();
        }
    }


    private static void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, AppConfig.DIR_IMG);
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPoolSize(3);//线程池大小，默认为3
        config.threadPriority(Thread.NORM_PRIORITY - 2);//线程优先级数
        config.denyCacheImageMultipleSizesInMemory();// 不允许在内存中缓存同一张图片的多个尺寸
        config.memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024));// 内存缓存策略
        config.memoryCacheSize(2 * 1024 * 1024);// 内存缓存大小
        config.discCache(new UnlimitedDiskCache(cacheDir));//自定义缓存路径
        config.diskCacheSize(50 * 1024 * 1024); // 20 MiB   设置磁盘缓存的大小
        config.discCacheFileCount(100); //缓存的文件数量
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());// 磁盘缓存时图片名称加密方式
        config.tasksProcessingOrder(QueueProcessingType.LIFO); // 设置处理队列的类型，包括LIFO， FIFO
        config.defaultDisplayImageOptions(DisplayImageOptions.createSimple());
        config.writeDebugLogs(); // Remove for release app
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }

    public static DisplayImageOptions getOptions(int vid){
        DisplayImageOptions options = new DisplayImageOptions.Builder()   //下载并且缓存
                .showImageOnFail(vid)
                .showImageOnLoading(vid)
                .cacheInMemory(true) // 需要缓存在内存中
                .cacheOnDisk(true) // 需要缓存到磁盘中
                .bitmapConfig(Bitmap.Config.RGB_565)// bitmap模式

                .showImageForEmptyUri(vid)// 路径为空时显示的图片
                .displayer(new RoundedBitmapDisplayer(20))//设置图片显示形式(圆角 or 渐变等)
                .resetViewBeforeLoading(false) // 将要开始加载时是否需要替换成onLoading图片
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // 缩放类型
                .build();
        return options;
    }
}
