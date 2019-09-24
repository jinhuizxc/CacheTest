package com.example.cachetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.cachetest.base.BaseResponse;
import com.example.cachetest.bean.HomeArticle;
import com.example.cachetest.net.ServerUtils;
import com.example.cachetest.net.callback.RequestCallback;
import com.example.cachetest.net.callback.RxErrorHandler;
import com.example.cachetest.utils.RetryWithDelay;
import com.example.cachetest.utils.RxUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 缓存测试
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_getData)
    Button btnGetData;
    @BindView(R.id.tv_cache)
    TextView tvCache;

    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_getData})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_getData:
                break;

        }
    }


}
