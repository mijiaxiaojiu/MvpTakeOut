package com.xiaojiu.mvpdmeo.presenter.base;

import com.xiaojiu.mvpdmeo.model.dao.bean.DBHelper;
import com.xiaojiu.mvpdmeo.presenter.api.ResponseInfoAPI;
import com.xiaojiu.mvpdmeo.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：${xiaojiukeji} on 17/3/1 21:11
 * 作用: 业务层公共部分代码封装
 */

public class BasePresenter {
    protected static ResponseInfoAPI responseInfoAPI;
    protected DBHelper dbHelper;
    //数据库
    //网络

    public BasePresenter() {
        //第一次初始化的时候所有的子类都可以使用
        if (responseInfoAPI == null) {
            //第一步,创建builder,指定baseUrl和数据解析工具
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(Constant.BASEURL);
            builder.addConverterFactory(GsonConverterFactory.create());//Gson解析
            //第二步:创建Retrofit
            Retrofit retrofit = builder.build();

            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }

        dbHelper = DBHelper.getInstance();//单例获取
    }
}
