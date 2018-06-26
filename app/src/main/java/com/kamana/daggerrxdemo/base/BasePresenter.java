package com.kamana.daggerrxdemo.base;

import com.kamana.daggerrxdemo.data.IDataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by kamana on 26/6/18.
 */

public class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    private T baseView;

    CompositeDisposable compositeDisposable;

    IDataManager iDataManager;

    @Inject
    public BasePresenter(IDataManager iDataManager, CompositeDisposable compositeDisposable){
        this.iDataManager = iDataManager;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void onDetach(T baseView) {

        if(baseView!=null){
            baseView=null;
        }

        compositeDisposable.dispose();
    }

    @Override
    public T getBaseView() {
        return baseView;
    }

    @Override
    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    public IDataManager getDataManager() {
        return iDataManager;
    }
}
