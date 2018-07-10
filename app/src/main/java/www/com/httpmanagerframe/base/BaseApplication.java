package www.com.httpmanagerframe.base;


import android.app.Application;

/**
 * @author: WANGWEI on 2018/1/9 0009.
 */

public class BaseApplication extends Application {
    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    // 单例Application
    public static BaseApplication getInstance() {
        synchronized (BaseApplication.class) {
            if (mInstance == null) {
                mInstance = new BaseApplication();
            }
        }
        return mInstance;
    }

}
