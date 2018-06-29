package com.tla.simplehabits.mvp.presenters;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.tla.simplehabits.mvp.views.BaseView;

public abstract class BasePresenter<V extends BaseView> extends ViewModel {

    protected V mView;
    protected MutableLiveData<String> mErrorLD;

    public void initPresenter(final V view) {
        this.mView = view;
        mErrorLD = new MutableLiveData<>();
    }

    public MutableLiveData<String> getErrorLD() {
        return mErrorLD;
    }

}
