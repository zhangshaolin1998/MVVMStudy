package com.bewei.mvvms.bean;

import android.text.TextUtils;
import android.util.Log;

import com.bewei.mvvms.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/11/14 15:01
 */


public class UserInfo {
    public String mobile;
    public String password;

    public UserInfo() {
    }

    public UserInfo(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  //点击事件
    public void onRegister(String mobile,String password){
        Log.i("xxx","点击"+mobile+","+password);
        if (TextUtils.isEmpty(mobile)&&TextUtils.isEmpty(password)){
            return;
        }
        register(mobile,password);

    }
  //网络请求 注册
    private void register(String mobile, String password) {
        Map<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        OkHttp3Utils.getInstance().doPost("https://www.zhaoapi.cn/user/reg", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (listener!=null){//失败回调
                    listener.onError(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if (listener!=null){//成功回调
                    listener.onSuccess(json);
                }
            }
        });


    }
    //接口回调
    private OnRegisterListener listener;
    public interface OnRegisterListener{
        void onSuccess(Object obj);
        void onError(IOException e);
    }
    public void setOnRegisterListener(OnRegisterListener listener){
        this.listener = listener;
    }
}
