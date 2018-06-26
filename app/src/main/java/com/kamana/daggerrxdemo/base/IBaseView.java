package com.kamana.daggerrxdemo.base;

/**
 * Created by kamana on 26/6/18.
 */

public interface IBaseView {

    public void configureToolbar();

    public void setToolbarTitle(String title);

    public String getToolbarTitle();

    public void showSnackbar(String message);

    public void displayToast(String message);

    public void showProgressDialog();

    public void hideProgressDialog();

    public void setVisibilityOfHome(boolean isHomeIconVisible);
}
