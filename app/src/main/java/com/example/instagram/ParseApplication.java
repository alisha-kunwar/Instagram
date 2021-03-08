package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //REGISTERING PARSE MODELS
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("toY6b96I2WGmVdcuOeC6p7z92MeotL9mldOoWJLW")
                .clientKey("MWRPyBfSdRsH6oczZdtWcERZcP1ABwVwy54iRy89")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

