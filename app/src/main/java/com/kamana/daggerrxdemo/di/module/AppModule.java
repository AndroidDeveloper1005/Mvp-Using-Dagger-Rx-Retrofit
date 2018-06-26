package com.kamana.daggerrxdemo.di.module;

import android.app.Application;

import com.kamana.daggerrxdemo.data.DataManager;
import com.kamana.daggerrxdemo.data.IDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kamana on 26/6/18.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory,
                             RxJava2CallAdapterFactory rxJavaCallAdapterFactory){

        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

    }

    @Singleton
    @Provides
    IDataManager provideDataManager(DataManager dataManager){
        return dataManager;
    }

}
