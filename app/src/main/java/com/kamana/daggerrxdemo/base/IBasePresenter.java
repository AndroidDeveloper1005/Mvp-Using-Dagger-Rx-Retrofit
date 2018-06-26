package com.kamana.daggerrxdemo.base;

import com.kamana.daggerrxdemo.data.IDataManager;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by kamana on 26/6/18.
 */

public interface IBasePresenter<T extends IBaseView> {

    public void onAttach(T baseView);

    public void onDetach(T baseView);

    public T getBaseView();

    public CompositeDisposable getCompositeDisposable();

    public IDataManager getDataManager();

}
