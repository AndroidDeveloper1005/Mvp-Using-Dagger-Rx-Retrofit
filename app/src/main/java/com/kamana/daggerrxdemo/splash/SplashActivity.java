package com.kamana.daggerrxdemo.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kamana.daggerrxdemo.R;
import com.kamana.daggerrxdemo.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by kamana on 26/6/18.
 */

public class SplashActivity extends BaseActivity implements ISplashView{

    @Inject
    ISplashPresenter<ISplashView> iSplashPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        iSplashPresenter.onAttach(this);
        iSplashPresenter.getCustomerData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
