package www.com.httpmanagerframe.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import www.com.httpmanagerframe.R;
import www.com.httpmanagerframe.dialog.AnimationDialog;


public abstract class BaseActivity extends AppCompatActivity {
    private AnimationDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Activity", "创建 " + getClass().getSimpleName());
    }


    /***
     *
     * @param layoutResID  layout布局文件
     *
     * 重写 setContentView 方法
     * 在 initView()中执行findView()
     * 在 initData()中接收inten传递的数据
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initData();
    }

    /****
     *
     * @param res  layout资源id
     * @param <T>
     * @return
     *
     * 简化findViewById(int id),使用时直接findView(int id) 且避免了类型转换
     */

    protected <T extends View> T findView(int res) {
        return (T) findViewById(res);
    }

    /***
     *
     * @param clazz  目标Activity
     *
     * startActivity(Class clazz)  添加跳转转场动画
     */
    public void startActivity(Class<?> clazz) {
        startActivity(clazz, null);
        overridePendingTransition(R.anim.from_right_in, R.anim.to_left_out);
    }

    /***
     *
     * @param clazz 目标Activity
     * @param bundle 传递bundle数据
     */
    public void startActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.from_right_in, R.anim.to_left_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
    }

    /***
     *   finish View 转场动画
     */
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.from_left_in, R.anim.to_right_out);
    }


    /***
     *
     * @param context
     *
     * 网络加载动画效果显示Dialog
     */
    public void showDialog(Context context) {
        if (dialog == null && context != null) {
            dialog = AnimationDialog.createDialog(context);      //点击是否消失
            dialog.setCanceledOnTouchOutside(false);
            try {
                dialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /***
     * 网络加载隐藏dialog
     */
    public void dismissDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    public abstract void initView();

    public void initData() {
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.from_right_in, R.anim.to_left_out);
    }
}


