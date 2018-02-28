package com.testhttp;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestHttp {

    private String username = "admin";

    private String password = "admin";

    private String loginUrl = "http://localhost:8080/login";

    private String dataUrl = "http://localhost:8080/getData";



    public static void main(String[] args) {
        try{

            TestHttp testHttp = new TestHttp();
            testHttp.testPost();
            System.out.println("~~~~~~~~~~~~~~~~");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void testPost() throws ClientProtocolException, IOException{

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpost = new HttpPost(loginUrl);
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        nvp.add(new BasicNameValuePair("username", username));
        nvp.add(new BasicNameValuePair("password", password));
        String sCharSet = "GB2312";
        httpost.setEntity(new UrlEncodedFormEntity(nvp, sCharSet));
        HttpResponse response = httpclient.execute(httpost);

        // 获得登陆后的 Cookie
/*        CookieStore cookies = httpclient.getCookieStore();
        StringBuffer tmpcookies = new StringBuffer();
        for (org.apache.http.cookie.Cookie c : cookies.getCookies()) {
            tmpcookies.append(c.toString() + ";");
            System.out.println("cookies = "+c.toString());
        }*/

        if(response!=null)
        {
            System.out.println(response.getFirstHeader("Location"));
            System.out.println(response.getStatusLine().getStatusCode());

            String url = "http://localhost:8080/getData";
            HttpGet httpget = new HttpGet(url);
            HttpResponse response1 = httpclient.execute(httpget);
            if(response1!=null)
            {
                HttpEntity entity = response1.getEntity();
                String strResult = EntityUtils.toString(entity, "UTF-8");
                System.out.println(strResult);
                EntityUtils.consume(entity);
            }

        }
        httpost.abort();
    }
}
