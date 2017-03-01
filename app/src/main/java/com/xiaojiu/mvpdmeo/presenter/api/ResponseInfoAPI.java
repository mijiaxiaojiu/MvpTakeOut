package com.xiaojiu.mvpdmeo.presenter.api;

import com.xiaojiu.mvpdmeo.model.net.bean.ResponseInfo;
import com.xiaojiu.mvpdmeo.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：${xiaojiukeji} on 17/3/1 21:37
 * 作用: 对请求方式和参数的封装
 */
public interface ResponseInfoAPI {
    @GET(Constant.LOGIN)
    Call<ResponseInfo> login(
            @Query("username")//参数的名字
                String username,
            @Query("password")
                String password
    );
}
