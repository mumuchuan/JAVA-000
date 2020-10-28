package com.jkhomework.work.httpClient;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：huabin
 * @date ：Created in 2020/10/26 21:31
 * @description：基于httpclient实现
 * @modified By：
 * @version: 1.0.0$
 */
public class HttpClient {


    public static void main(String[] args) throws IOException {
        String result = httpGet("http://127.0.0.1:8801");
        System.out.println("--------------------------------------------->【HttpClient】请求结果:" + result);
    }

    /**
     * http get请求
     *
     * @param url
     * @return
     */
    public static String httpGet(String url) {
        String responseContent = null;
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpclient = HttpClients.createDefault();
            response = httpclient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                responseContent = getRespString(entity);
                EntityUtils.consume(entity);
            } else {
                System.out.println("--------------httpGet-------请求失败---");
            }
        } catch (Exception e) {
            System.out.println("--------------httpGet-------http get请求，出现异常：" + e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
            }
            try {
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
            }
        }
        return responseContent;
    }

    /**
     * 将返回结果转化为String
     *
     * @param entity
     * @return
     * @throws Exception
     */
    private static String getRespString(HttpEntity entity) throws Exception {
        if (entity == null) {
            return null;
        }
        InputStream is = entity.getContent();
        StringBuffer strBuf = new StringBuffer();
        byte[] buffer = new byte[4096];
        int r = 0;
        while ((r = is.read(buffer)) > 0) {
            strBuf.append(new String(buffer, 0, r, "UTF-8"));
        }
        return strBuf.toString();
    }

}
