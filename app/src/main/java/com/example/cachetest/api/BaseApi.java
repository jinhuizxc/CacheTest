package com.example.cachetest.api;


import com.example.cachetest.base.BaseResponse;
import com.example.cachetest.bean.HomeArticle;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 网络请求接口
 */
public interface BaseApi {


    //首页文章列表
    @GET("article/list/{page}/json")
    Observable<BaseResponse<HomeArticle>> getHomeArticle(@Path("page") int page);

}
