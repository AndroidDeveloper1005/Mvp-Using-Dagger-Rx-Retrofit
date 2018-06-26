package com.kamana.daggerrxdemo.di.component;

import android.app.Application;

import com.kamana.daggerrxdemo.App;
import com.kamana.daggerrxdemo.data.IDataManager;
import com.kamana.daggerrxdemo.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kamana on 26/6/18.
 */

@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    void inject(App app);

    Application application();

    GsonConverterFactory gsonConverterFactory();

    RxJava2CallAdapterFactory rxJavaCallAdapterFactory();

    Retrofit retrofit();

    IDataManager dataManager();

}
