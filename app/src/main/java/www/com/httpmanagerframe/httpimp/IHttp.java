package www.com.httpmanagerframe.httpimp;


import www.com.httpmanagerframe.callback.MyHttpRequestCallBack;
/**
 * @author: WANGWEI
 *
 */

public interface IHttp<T> {
	void setBack(MyHttpRequestCallBack<T> back);
	void start();
}
