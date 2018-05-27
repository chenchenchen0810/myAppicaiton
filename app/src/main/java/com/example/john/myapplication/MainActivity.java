package com.example.john.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;

    private ImageLoader imageLoader;
    private List<String> mList = new ArrayList<>();
    private ListAdapter adapter;
//    private MyListViewOnItemClickListener myListViewOnItemClickListener = new MyListViewOnItemClickListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageLoader = ImageLoader.getInstance();
//        imageLoader.displayImage("drawable://" + R.drawable.approve_fail, img);
        for (int i = 0; i < 10; i++) {
            mList.add(i + "");
        }
        adapter = new ListAdapter(this, mList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position+"", Toast.LENGTH_LONG).show();
            }
        });
    }

//    private class MyListViewOnItemClickListener implements AdapterView.OnItemClickListener{
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(MainActivity.this,position+"", Toast.LENGTH_LONG).show();
//        }
//    }


    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Toast.makeText(MainActivity.this,"1", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn2:
                Toast.makeText(MainActivity.this,"2",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn3:
                Toast.makeText(MainActivity.this,"3",Toast.LENGTH_LONG).show();
                break;
        }
    }


}
