package com.example.cachetest.presenter;

import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;
import com.example.cachetest.base.BaseResponse;
import com.example.cachetest.bean.HomeArticle;
import com.example.cachetest.contract.HomeArticleContract;
import com.example.cachetest.net.ServerUtils;
import com.example.cachetest.net.callback.RequestCallback;
import com.example.cachetest.net.callback.RxErrorHandler;
import com.example.cachetest.utils.RetryWithDelay;
import com.example.cachetest.utils.RxUtils;

/**
 * HomeArticleContract  P
 */
public class HomeArticlePresenter extends HomeArticleContract.Presenter{

    private Context context;

    public HomeArticlePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void getData(int page,boolean isDialog, boolean cancelable) {
        ServerUtils.getCommonApi().getHomeArticle(page)
                .retryWhen(new RetryWithDelay(3,2))
                .compose(RxUtils.<BaseResponse<HomeArticle>>bindToLifecycle(getView()))
                .compose(RxUtils.<BaseResponse<HomeArticle>>getSchedulerTransformer())
                .subscribe(new RequestCallback<BaseResponse<HomeArticle>>(context, RxErrorHandler.getInstance(),isDialog,cancelable) {
                    @Override
                    public void onNext(BaseResponse<HomeArticle> baseResponse) {
                        super.onNext(baseResponse);
                        if(baseResponse.getCode() == 0){
                            getView().getDataResult(baseResponse);
                        }else{
                            ToastUtils.showShort(baseResponse.getMsg());
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }



}
