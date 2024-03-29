package com.example.cachetest.base;


/**
 * BasePresenter
 */
public abstract class BasePresenter<V extends BaseView>{

    private V mView;

    public V getView(){
        return mView;
    }

    public void attachView(V v){
        mView = v;
    }

    public void detachView(){
        mView = null;
    }


}
