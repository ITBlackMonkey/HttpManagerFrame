package www.com.httpmanagerframe.request;


import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.MediaType;
import www.com.httpmanagerframe.callback.MyHttpRequestCallBack;

/**
 * @author: WANGWEI
 *
 * OkHttputils 进行网络访问
 */

public class HttpRequest {

    public HttpRequest(RequestEntity requestEntity, MyHttpRequestCallBack httpRequestCallBack) {
        OkHttpUtils.postString()
                .url(HTTPConstants.URL)
                .content(requestEntity.toJSONString())
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build().execute(httpRequestCallBack);
    }
}
