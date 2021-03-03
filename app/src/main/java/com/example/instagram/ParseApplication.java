package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("sQTZpoGVFHeppATs75kxlwd4kiExQRvYne1a90cD")
                .clientKey("IwqLCpbYRDBo3M7oVj0tedl1LITLcxiHrl3kOKDF")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
