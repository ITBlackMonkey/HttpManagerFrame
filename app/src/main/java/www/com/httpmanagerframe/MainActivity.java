package www.com.httpmanagerframe;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import www.com.httpmanagerframe.base.BaseActivity;
import www.com.httpmanagerframe.callback.MyHttpRequestCallBack;
import www.com.httpmanagerframe.response.Result;
import www.com.httpmanagerframe.test.HTTPTestImp;

/***
 *  网络请求测试类
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        findViewById(R.id.btn).setOnClickListener(this);
        textView = findView(R.id.text);
    }

    @Override
    public void onClick(View v) {

        HTTPTestImp httpTestImp = new HTTPTestImp(this);
        httpTestImp.setBack(new MyHttpRequestCallBack<String>(String.class, this) {
            @Override
            public void onSuccess(Result<String> t) {
                String body = t.getBODY();
                textView.setText(body);
            }
        });
        httpTestImp.start();
    }
}
