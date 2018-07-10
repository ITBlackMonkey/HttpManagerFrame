package www.com.httpmanagerframe.callback;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import okhttp3.Call;
import www.com.httpmanagerframe.base.BaseActivity;
import www.com.httpmanagerframe.response.Result;
import www.com.httpmanagerframe.utils.ToastUtils;

/**
 * @author: WANGWEI
 */

public abstract class MyHttpRequestCallBack<T> extends BaseHttpCallBack<T> {
    private Class<?>     clazz;
    public  BaseActivity activity;
    private boolean isShowDialog = true;

    public MyHttpRequestCallBack(Class<?> clazz, Context activity) {
        this.activity = (BaseActivity) activity;
        this.clazz = clazz;
        context = activity;
    }

    /****
     *
     * @param response
     * @param id
     *
     * 网络请求返回数据
     */
    @Override
    public void onResponse(String response, int id) {
        try {
            String strResponse = response.trim();
            Log.e("result", strResponse);
            Result<T> result = (Result<T>) JSONObject.parseObject(strResponse, Result.class);
            JSONObject object = JSONObject.parseObject(strResponse);
            T t = (T) object.parseObject(strResponse, clazz);
            result.setBODY(t);

            /***
             * 后台服务返回成功码
             */
            /*if (ResponseCode.resCodeSuccess.equals(result.getCode())) {
                 onSuccess(result);
            } else {
                if (context != null) {
                    ToastUtils.show(context, result.getMsg());
                    onFailure(result.getMsg());
                }
            }*/

            if (t != null) {
                onSuccess(result);
            } else
                onFailure(result.getBODY().toString());
        } catch (Exception e) {
            onError(null, e, 0);
        } finally {
            dismissDialog();
        }
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        dismissDialog();
        if (context != null) {
            onFailure(e.getMessage());
        }
    }

    public abstract void onSuccess(Result<T> t);


    public void onFailure(String msg) {
        ToastUtils.show(context, msg);
    }

    private void dismissDialog() {
        if (this.activity != null) {
            this.activity.dismissDialog();
        }
    }
}
