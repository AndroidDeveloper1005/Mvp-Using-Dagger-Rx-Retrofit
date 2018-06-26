package com.kamana.daggerrxdemo;

import android.app.Application;


import com.kamana.daggerrxdemo.data.IDataManager;
import com.kamana.daggerrxdemo.di.component.DaggerApplicationComponent;
import com.kamana.daggerrxdemo.di.module.AppModule;
import com.kamana.daggerrxdemo.di.component.ApplicationComponent;

import javax.inject.Inject;

/**
 * Created by kamana on 26/6/18.
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Inject
    IDataManager iDataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                                .appModule(new AppModule(this))
                                .build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
