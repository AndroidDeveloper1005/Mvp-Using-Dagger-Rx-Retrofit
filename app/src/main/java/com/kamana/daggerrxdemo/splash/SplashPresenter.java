package com.kamana.daggerrxdemo.splash;

import com.kamana.daggerrxdemo.data.IDataManager;
import com.kamana.daggerrxdemo.base.BasePresenter;
import com.kamana.daggerrxdemo.modals.CustomerResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by kamana on 26/6/18.
 */

public class SplashPresenter<T extends ISplashView> extends BasePresenter<T> implements ISplashPresenter<T> {

    @Inject
    public SplashPresenter(IDataManager iDataManager, CompositeDisposable compositeDisposable) {
        super(iDataManager, compositeDisposable);
    }

    @Override
    public void onAttach(T baseView) {
        super.onAttach(baseView);
    }

    @Override
    public void onDetach(T baseView) {
        super.onDetach(baseView);
    }


    @Override
    public void getCustomerData() {

        getCompositeDisposable().add(getDataManager()
                .getCustomerResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<CustomerResponse>>() {
                    @Override
                    public void accept(List<CustomerResponse> customerResponses) throws Exception {
                        List<CustomerResponse> customerResponseList = customerResponses;
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                })

        );
/*                (Disposable) getDataManager()
                .getCustomerResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<CustomerResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<CustomerResponse> customerResponses) {
                        List<CustomerResponse> getCustomerResponse = customerResponses;
                    }
                }));*/
    }
}
