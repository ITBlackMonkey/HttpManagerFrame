package www.com.httpmanagerframe.test;

import android.content.Context;

import www.com.httpmanagerframe.httpimp.HttpManager;
import www.com.httpmanagerframe.request.HttpRequest;
import www.com.httpmanagerframe.request.RequestEntity;

/**
 * @author: WANGWEI
 */

public class HTTPTestImp extends HttpManager<String> {

    Context context;


    public HTTPTestImp(Context context) {
        this.context = context;
    }

    @Override
    public void start() {
        super.start();

        RequestEntity requestEntity = RequestEntity.getInstance();

        requestEntity.putBODY("name", "zhangsan");
        requestEntity.putBODY("age", "lisi");

        new HttpRequest(requestEntity, back);
    }
}
