package com.tuodi.utils;

import com.google.gson.annotations.SerializedName;

import rx.Observable;

/**
 * Created by dsliang on 2017/5/5.
 */

public class NetworkResponseUtils {

    //    0:成功
    public static final int SUCCESS = 0;

    //    100:请求错误
    public static final int REQUEST_ERROR = 100;

    //    101:缺少认证
    public static final int UNAUTHERIZED = 101;

    //    102:缺少参数
    public static final int PARAMETER_MISS = 102;

    //    103:参数错误
    public static final int PARAMETER_ERROR = 103;

    //    200:服务器出错
    public static final int SERVER_ERROR = 200;

    //    201:服务不可用
    public static final int SERVER_UNAVAILABLE = 201;

    //    202:服务器正在重启
    public static final int SERVER_RESTART = 202;

    public static boolean isResponseSuccess(NetworkResponse response) {

        return SUCCESS == response.code ? true : false;
    }

    public <T> Observable<T> justData(NetworkResponse<T> response) {
        if (!isResponseSuccess(response)) {
            return Observable.error(new Exception(response.message));
        }
        return Observable.just(response.data);
    }

    public static class NetworkResponse<T> {
        @SerializedName("code")
        public int code;

        @SerializedName("message")
        public String message;

        @SerializedName("addition")
        public String addition;

        @SerializedName("data")
        public T data;
    }

}
