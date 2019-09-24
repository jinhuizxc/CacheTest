package com.example.cachetest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cachetest.base.BaseActivity;
import com.example.cachetest.base.BaseResponse;
import com.example.cachetest.bean.HomeArticle;
import com.example.cachetest.contract.HomeArticleContract;
import com.example.cachetest.presenter.HomeArticlePresenter;
import com.example.cachetest.utils.ACache;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 缓存测试
 */
public class HomeArticleActivity extends BaseActivity<HomeArticleContract.View, HomeArticleContract.Presenter>
        implements HomeArticleContract.View {

    @BindView(R.id.btn_getData)
    Button btnGetData;
    @BindView(R.id.tv_cache)
    TextView tvCache;
    @BindView(R.id.btn_getCache)
    Button btnGetCache;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private int currentPage = 0;

    private static final String TAG = "HomeArticleActivity";
    private File cacheFile;


    @Override
    public int getLayoutId() {
        return R.layout.activity_home_article;
    }

    @Override
    public void init() {

        // 设置cache
        cacheFile = new File(AppConfig.PATH_CACHE);
        Log.e(TAG, "缓存路径: " + cacheFile.getAbsolutePath());
        tvCache.setText(ACache.getCacheSize(cacheFile));
    }


    @OnClick({R.id.btn_getData, R.id.btn_getCache})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_getData:
                getData();
                break;
            case R.id.btn_getCache:
                getCache();
                break;

        }
    }

    private void getCache() {
        tvCache.setText(ACache.getCacheSize(cacheFile));
    }

    @Override
    public HomeArticleContract.Presenter createPresenter() {
        return new HomeArticlePresenter(this);
    }

    @Override
    public HomeArticleContract.View createView() {
        return this;
    }


    private void getData() {
        getPresenter().getData(currentPage, false, true);
    }

    @Override
    public void getDataResult(BaseResponse<HomeArticle> data) {
        Log.e(TAG, "getDataResult: " + data);
        tvResult.setText(data.getData().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
