package www.com.httpmanagerframe.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: WANGWEI .
 */

public class URLUtils {
    /**
     * 得到参数列表字符串
     * @param method   请求类型 get or  post
     * @param paramValues 参数map对象
     * @return  参数列表字符串
     */
    public static String getParams(String method, Map<String, String> paramValues)
    {
        String params="";
        Set<String> key = paramValues.keySet();
        String beginLetter="";
        if (method.equalsIgnoreCase("get"))
        {
            beginLetter="?";
        }

        for (Iterator<String> it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            if (params.equals(""))
            {
                params += beginLetter + s + "=" + paramValues.get(s);
            }
            else
            {
                params += "&" + s + "=" + paramValues.get(s);
            }
        }
        return params;
    }

}
