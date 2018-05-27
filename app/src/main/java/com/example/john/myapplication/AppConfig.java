package com.example.john.myapplication;

import android.os.Environment;

import java.io.File;

/**
 * Created by john on 2018/3/22.
 */

public class AppConfig {

    //手机缓存主目录
    public static final String APP_Path = Environment.getExternalStorageDirectory().getPath() + File.separator + "MyApplication";

    //图片缓存目录
    public static final String DIR_IMG = APP_Path + File.separator + "image";


}
