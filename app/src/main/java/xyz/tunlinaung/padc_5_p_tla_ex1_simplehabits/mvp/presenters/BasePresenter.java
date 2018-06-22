package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.presenters;


import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.views.BaseView;

public abstract class BasePresenter<V extends BaseView> {

    protected V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public void onCreate() {

    }

    public void onStart() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    public void onDestroy() {

    }

}
