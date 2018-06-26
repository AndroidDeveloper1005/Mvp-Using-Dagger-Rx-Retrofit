package com.kamana.daggerrxdemo.di.module;

import android.support.v7.app.AppCompatActivity;

import com.kamana.daggerrxdemo.di.PerActivity;
import com.kamana.daggerrxdemo.splash.ISplashPresenter;
import com.kamana.daggerrxdemo.splash.ISplashView;
import com.kamana.daggerrxdemo.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by kamana on 26/6/18.
 */

@Module
public class ActivityModule {

    AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity){
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    AppCompatActivity provideAppCompatActivity(){
        return appCompatActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @PerActivity
    @Provides
    ISplashPresenter<ISplashView> provideSplashPresenter(SplashPresenter<ISplashView> splashPresenter){
        return splashPresenter;
    }
}
