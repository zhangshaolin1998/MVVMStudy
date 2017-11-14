package com.bewei.mvvms.bean;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/11/14 10:59
 */


public class User {
    public String name;
    public int age;
    public String imgUrl;

    public User() {
    }

    public User(String name, int age, String imgUrl) {
        this.name = name;
        this.age = age;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    @BindingAdapter("bind:imgUrl")
    public static void getImg(ImageView iv,String imgUrl){
        Picasso.with(iv.getContext()).load(imgUrl).into(iv);
    }
}
