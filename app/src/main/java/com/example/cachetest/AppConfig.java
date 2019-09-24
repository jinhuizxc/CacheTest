package com.example.cachetest;


import com.example.cachetest.utils.ConstantUtils;

/**
 * APP配置参数
 */
public class AppConfig {


    public static final String BASE_URL = "https://www.wanandroid.com/";

    public static final String PATH_DATA = ConstantUtils.getAPPContext().getCacheDir().getAbsolutePath()+"/"+"data";

    public static final String PATH_CACHE = PATH_DATA+"/"+"Cache";

}
