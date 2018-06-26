package com.kamana.daggerrxdemo.data;

import com.kamana.daggerrxdemo.modals.CustomerResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by kamana on 26/6/18.
 */

public interface IDataManager {

    public Observable<List<CustomerResponse>> getCustomerResponse();
}
