package com.bewei.mvvms.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bewei.mvvms.R;
import com.bewei.mvvms.bean.UserInfo;
import com.bewei.mvvms.databinding.ActivityRegisterBinding;

import java.io.IOException;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/11/14 15:00
 */


public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获得ViewModel
     ActivityRegisterBinding registerBinding =DataBindingUtil.setContentView(this, R.layout.activity_register);
        UserInfo userInfo = new UserInfo();
     //把model设置给ViewModel
        registerBinding.setUserinfo(userInfo);
        userInfo.setOnRegisterListener(new UserInfo.OnRegisterListener() {
            @Override
            public void onSuccess(Object obj) {
                Log.i("xxx",obj.toString());
            }

            @Override
            public void onError(IOException e) {
                Log.i("xxx",e.getMessage());

            }
        });


    }
}
