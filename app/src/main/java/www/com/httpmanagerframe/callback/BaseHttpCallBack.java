package www.com.httpmanagerframe.callback;

import android.content.Context;

import com.zhy.http.okhttp.callback.StringCallback;

import www.com.httpmanagerframe.response.Result;


/**
 * @author: WANGWEI
 *
 */

public abstract class BaseHttpCallBack<T> extends StringCallback {

    public Context context;

    protected abstract void onSuccess(Result<T> t);

    protected abstract void onFailure(String msg);

}
