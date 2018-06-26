package com.kamana.daggerrxdemo.data;

import com.kamana.daggerrxdemo.modals.CustomerResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Retrofit;


/**
 * Created by kamana on 26/6/18.
 */

@Singleton
public class DataManager implements IDataManager{

    Retrofit retrofit;

    @Inject
    public DataManager(Retrofit retrofit){

        this.retrofit = retrofit;
    }

    @Override
    public Observable<List<CustomerResponse>> getCustomerResponse() {
        return retrofit.create(ApiService.class).getCustomerResponse();
    }
}
