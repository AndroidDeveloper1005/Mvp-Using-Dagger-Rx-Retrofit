package com.kamana.daggerrxdemo.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.kamana.daggerrxdemo.App;
import com.kamana.daggerrxdemo.R;
import com.kamana.daggerrxdemo.di.module.ActivityModule;
import com.kamana.daggerrxdemo.di.component.ActivityComponent;
import com.kamana.daggerrxdemo.di.component.DaggerActivityComponent;

/**
 * Created by kamana on 26/6/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView{

    ActivityComponent activityComponent;

    private Toolbar mToolbar;

    private ImageView ivHomeIcon;

    private String toolbarTitle;

    Activity activity;

    private ProgressDialog progressDialog;

    private boolean isHomeIconVisible = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        activityComponent = DaggerActivityComponent.builder()
                            .applicationComponent(((App)getApplication()).getApplicationComponent())
                            .activityModule(new ActivityModule(this))
                            .build();

        configureToolbar();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected abstract int getLayoutId();

    @Override
    public void configureToolbar(){

        mToolbar = findViewById(R.id.toolbar);
        ivHomeIcon = findViewById(R.id.ivHome);

        if(mToolbar!=null){
            if(getToolbarTitle()!=null && !getToolbarTitle().trim().equalsIgnoreCase("")){
                mToolbar.setTitle(getToolbarTitle());
            }

            setSupportActionBar(mToolbar);
            getSupportActionBar().setElevation(4f);
        }

    }

    @Override
    public abstract void setToolbarTitle(String toolbarTitle);

    public String getToolbarTitle(){
        setToolbarTitle(toolbarTitle);
        return toolbarTitle;
    }
}
