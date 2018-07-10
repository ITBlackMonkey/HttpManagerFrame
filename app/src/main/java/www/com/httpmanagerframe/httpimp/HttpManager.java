package www.com.httpmanagerframe.httpimp;


import www.com.httpmanagerframe.base.BaseActivity;
import www.com.httpmanagerframe.callback.MyHttpRequestCallBack;

/**
 * @author: WANGWEI
 *
 */

public abstract class HttpManager<T> implements IHttp<T> {
    public MyHttpRequestCallBack<T> back;
    private BaseActivity activity;


    @Override
    public void start() {
        if (back.context != null) {
            activity = (BaseActivity) back.context;
            activity.showDialog(activity);
        }
    }
    @Override
    public void setBack(MyHttpRequestCallBack<T> back) {
        this.back = back;
    }
}
