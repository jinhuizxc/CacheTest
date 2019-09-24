package com.example.cachetest.net.callback;


import com.blankj.utilcode.util.ToastUtils;
import com.example.cachetest.utils.LogUtils;

public class RxErrorHandler implements ErrorListener {

    private volatile static RxErrorHandler rxErrorHandler;

    private RxErrorHandler() {
    }

    public static RxErrorHandler getInstance() {
        if (rxErrorHandler == null) {
            synchronized (RxErrorHandler.class) {
                if (rxErrorHandler == null) {
                    rxErrorHandler = new RxErrorHandler();
                }
            }
        }
        return rxErrorHandler;
    }

    @Override
    public void handleError(Throwable throwable) {
        String errorString = throwable.toString();
        LogUtils.e("网络错误信息为 ========>>>" + throwable.toString());
        //返回的错误为空
        if (errorString == null) {
            ToastUtils.showShort("网络数据异常，请重试");

        } else {
            //请求超时
            if (errorString.contains("TimeoutException") || errorString.contains("SocketTimeoutException")) {
                ToastUtils.showShort("网络请求超时，请重试");
            }
            //能识别的请求异常，忽略不提示
            if (errorString.contains("SSLException")) {

            }
            //403、404等服务错误
            if (errorString.contains("ServiceConfigurationError") || errorString.contains("AuthenticatorException")) {
                ToastUtils.showShort("网络数据异常，请重试");
            }
            //网络未连接
            if (errorString.contains("NetworkErrorException") || errorString.contains("NoConnectionPendingException") || errorString.contains("UnknownHostException")) {
                ToastUtils.showShort("您的网络不给力，请检查网络设置");
            }
            //连接不到服务器
            if (errorString.contains("ConnectException")) {
                ToastUtils.showShort("网络连接失败");
            }
        }
    }
}