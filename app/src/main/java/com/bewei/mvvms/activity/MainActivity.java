package com.bewei.mvvms.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bewei.mvvms.R;
import com.bewei.mvvms.bean.User;
import com.bewei.mvvms.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding amb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("张三",30,"http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg");
        amb.setUser(user);

    }



}
