package com.renxin.cheku.base_library.data_source.net;

import com.renxin.cheku.base_library.utils.Timber;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Desc: 所有使用到的API
 * Created by ${junhua.li} on 2016/03/23 16:49.
 * Email: lijunhuayc@sina.com
 */
public class HttpURLAPI {
    /**
     * 构建 GET 方式请求 URL
     *
     * @param url
     * @param params
     */
    public static String buildGetURL(String url, Map<String, String> params) {
        return buildGetURL(url, params, "UTF-8");
    }

    private static String buildGetURL(String url, Map<String, String> params, String paramsEncoding) {
        StringBuilder sBuilder = new StringBuilder(url);
        if (null != params) {
            int qMarkIndex = sBuilder.indexOf("?");//问号在URL中的位置
            int length = sBuilder.length();//URL总长度
            if (qMarkIndex == length - 1) {//问号处于末尾
            } else if (qMarkIndex == -1) {//无问号
                sBuilder.append("?");
            } else {//有问号且不处于末尾
                sBuilder.append("&");
            }
            try {
                for (String key : params.keySet()) {
                    sBuilder.append(URLEncoder.encode(key, paramsEncoding));
                    sBuilder.append("=");
                    sBuilder.append(URLEncoder.encode(params.get(key), paramsEncoding));
                    sBuilder.append("&");
                }
                char lastStr = sBuilder.charAt(sBuilder.length() - 1);
                if ('?' == lastStr || '&' == lastStr) {
                    sBuilder.deleteCharAt(sBuilder.length() - 1);
                }
            } catch (UnsupportedEncodingException var6) {
                Timber.d("buildGetURL: %s Encoding not supported, exception info = \n %s", paramsEncoding, var6.getMessage());
                var6.printStackTrace();
                return sBuilder.toString();
            }
        }
//        Timber.i("buildGetURL: build url = %s", sBuilder.toString());
        return sBuilder.toString();
    }
}
