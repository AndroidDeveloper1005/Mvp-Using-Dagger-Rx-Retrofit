package com.kamana.daggerrxdemo.data;

import com.kamana.daggerrxdemo.modals.CustomerResponse;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by kamana on 26/6/18.
 */
@Singleton
public interface ApiService {

    @GET("users")
    Observable<List<CustomerResponse>> getCustomerResponse();

}
