package com.example.cachetest.contract;

import com.example.cachetest.base.BasePresenter;
import com.example.cachetest.base.BaseResponse;
import com.example.cachetest.base.BaseView;
import com.example.cachetest.bean.HomeArticle;


public interface HomeArticleContract {

    interface View extends BaseView {

        void getDataResult(BaseResponse<HomeArticle> data);


    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void getData(int page,boolean isDialog, boolean cancelable);

    }
}
