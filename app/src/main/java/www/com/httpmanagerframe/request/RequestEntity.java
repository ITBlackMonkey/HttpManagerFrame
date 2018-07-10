package www.com.httpmanagerframe.request;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import www.com.httpmanagerframe.base.BaseApplication;


/**
 * @author: WANGWEI
 *
 * 请求报文实体
 */

public class RequestEntity {
    private static final RequestEntity ENTITY    = new RequestEntity();
    private              JSONObject    systemObj = JSONObject.parseObject("{}");
    private              JSONObject    body      = JSONObject.parseObject("{}");
    private              JSONObject    appHead   = JSONObject.parseObject("{}");
    private              JSONObject    ctrlData  = JSONObject.parseObject("{}");
    private              JSONObject    json      = JSONObject.parseObject("{}");


    public static RequestEntity getInstance() {
        ENTITY.systemObj.clear();
        ENTITY.body.clear();
        ENTITY.appHead.clear();
        ENTITY.ctrlData.clear();
        ENTITY.json.clear();
        ENTITY.putVERSION(ENTITY.getVersionName());
        return ENTITY;
    }


    public void putUSER_ID(String value) {
        systemObj.put("USER_ID", value);
    }

    public void putVERSION(String value) {
        systemObj.put("VERSION", value);
    }


    public void putAPPHEAD(String key, Object value) {
        appHead.put(key, value);
    }

    public void putTRAN_CODE(String value) {
        json.put("tranCode", value);
    }

    public void putCTRLDATA(String key, Object value) {
        ctrlData.put(key, value);
    }

    public void putBODY(String key, String value) {
        if (!TextUtils.isEmpty(value)) {
            json.put(key, value);
        }

    }

    public void putBODY(String key, Object value) {
        json.put(key, value);
    }

    public void putBODYARRAY(String key, Object... object) {
        Object[] objArray = new Object[object.length];
        for (int i = 0; i < object.length; i++) {
            objArray[i] = object[i];
        }
        json.put(key, objArray);
    }

    private String getVersionName() {
        try {
            BaseApplication application = BaseApplication.getInstance();
            String pkName = application.getPackageName();
            String versionName = application.getPackageManager().getPackageInfo(pkName, 0).versionName;
            return versionName;
        } catch (Exception e) {
        }
        return "";
    }


    public String toJSONString() {
        /**
         *拼装报文头
         */
        //        json.put("reqHead", appHead);
        System.out.println(json.toString());
        /**
         * 拼装报文体
         */
        Log.i("requestParams", json.toString());
        return json.toString();
    }

}
