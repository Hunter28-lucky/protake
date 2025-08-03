package com.blink.academy.film.http.okhttp.exception;

import android.net.ParseException;
import com.blink.academy.film.http.okhttp.model.ApiResult;
import com.blink.academy.film.netbean.ErrorBean;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import defpackage.AbstractC4809;
import defpackage.r1;
import java.io.IOException;
import java.io.NotSerializableException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import retrofit2.HttpException;

/* loaded from: classes.dex */
public class ApiException extends Exception {
    private static final int BADREQUEST = 400;
    private static final int BAD_GATEWAY = 502;
    private static final int FORBIDDEN = 403;
    private static final int GATEWAY_TIMEOUT = 504;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int METHOD_NOT_ALLOWED = 405;
    private static final int NOT_FOUND = 404;
    public static final int PARSE_ERROR = 1001;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int SERVICE_UNAVAILABLE = 503;
    public static final int UNAUTHORIZED = 401;
    public static final int UNKNOWN = 1000;
    private final int code;
    private String displayMessage;
    private ErrorBean errorBean;
    private String message;

    public static class ERROR {
        public static final int CAST_ERROR = 1007;
        public static final int HTTP_ERROR = 1003;
        public static final int INVOKE_ERROR = 1006;
        public static final int NETWORD_ERROR = 1002;
        public static final int NULLPOINTER_EXCEPTION = 1010;
        public static final int PARSE_ERROR = 1001;
        public static final int REQUEST_CANCEL = 1008;
        public static final int SSL_ERROR = 1004;
        public static final int TIMEOUT_ERROR = 1005;
        public static final int UNKNOWN = 1000;
        public static final int UNKNOWNHOST_ERROR = 1009;
    }

    public ApiException(Throwable th, int i) {
        super(th);
        this.code = i;
        this.message = th.getMessage();
    }

    public static ApiException handleException(Throwable th) {
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            ApiException apiException = new ApiException(httpException, httpException.code());
            String message = httpException.getMessage();
            AbstractC4809 abstractC4809ErrorBody = httpException.response().errorBody();
            if (abstractC4809ErrorBody != null) {
                try {
                    message = abstractC4809ErrorBody.string();
                    if (r1.m8143(message)) {
                        ErrorBean errorBean = null;
                        try {
                            errorBean = (ErrorBean) new Gson().fromJson(message, ErrorBean.class);
                        } catch (Exception unused) {
                        }
                        if (errorBean != null) {
                            apiException.errorBean = errorBean;
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            apiException.message = message;
            return apiException;
        }
        if (th instanceof ServerException) {
            ServerException serverException = (ServerException) th;
            ApiException apiException2 = new ApiException(serverException, serverException.getErrCode());
            apiException2.message = serverException.getMessage();
            return apiException2;
        }
        if ((th instanceof JsonParseException) || (th instanceof JSONException) || (th instanceof JsonSyntaxException) || (th instanceof JsonSerializer) || (th instanceof NotSerializableException) || (th instanceof ParseException)) {
            ApiException apiException3 = new ApiException(th, 1001);
            apiException3.message = "解析错误";
            return apiException3;
        }
        if (th instanceof ClassCastException) {
            ApiException apiException4 = new ApiException(th, 1007);
            apiException4.message = "类型转换错误";
            return apiException4;
        }
        if (th instanceof ConnectException) {
            ApiException apiException5 = new ApiException(th, 1002);
            apiException5.message = "连接失败";
            return apiException5;
        }
        if (th instanceof SSLHandshakeException) {
            ApiException apiException6 = new ApiException(th, 1004);
            apiException6.message = "证书验证失败";
            return apiException6;
        }
        if (th instanceof ConnectTimeoutException) {
            ApiException apiException7 = new ApiException(th, 1005);
            apiException7.message = "连接超时";
            return apiException7;
        }
        if (th instanceof SocketTimeoutException) {
            ApiException apiException8 = new ApiException(th, 1005);
            apiException8.message = "连接超时";
            return apiException8;
        }
        if (th instanceof UnknownHostException) {
            ApiException apiException9 = new ApiException(th, 1009);
            apiException9.message = "无法解析该域名";
            return apiException9;
        }
        if (th instanceof NullPointerException) {
            ApiException apiException10 = new ApiException(th, 1010);
            apiException10.message = "NullPointerException";
            return apiException10;
        }
        ApiException apiException11 = new ApiException(th, 1000);
        apiException11.message = "未知错误";
        return apiException11;
    }

    public static boolean isOk(ApiResult apiResult) {
        return apiResult != null && apiResult.isOk();
    }

    public int getCode() {
        return this.code;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public ErrorBean getErrorBean() {
        return this.errorBean;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public void setDisplayMessage(String str) {
        this.displayMessage = str + "(code:" + this.code + ")";
    }
}
