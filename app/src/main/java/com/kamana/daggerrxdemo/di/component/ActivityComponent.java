package com.kamana.daggerrxdemo.di.component;

import android.support.v7.app.AppCompatActivity;

import com.kamana.daggerrxdemo.di.module.ActivityModule;
import com.kamana.daggerrxdemo.di.PerActivity;
import com.kamana.daggerrxdemo.splash.SplashActivity;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by kamana on 26/6/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    AppCompatActivity actiivity();

    CompositeDisposable compositeDisposable();

    void inject(SplashActivity splashActivity);
}
