package com.testhttp;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
    * @ClassName: HttpLogin
    * @Description:  java通过httpclient获取cookie模拟登录
    * @author zeze
    * @date 2015年11月10日 下午4:18:08
    *
 */
 
public class HttpLogin {
 
    public static void main(String[] args) {
        // 登陆 Url
        String loginUrl = "http://localhost:8080/login";
        // 需登陆后访问的 Url
        String dataUrl = "http://localhost:8080/getData";
        HttpClient httpClient = new HttpClient();
 
        // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
        PostMethod postMethod = new PostMethod(loginUrl);
 
        // 设置登陆时要求的信息，用户名和密码
        NameValuePair[] data = { new NameValuePair("username", "admin"), new NameValuePair("password", "admin") };
        postMethod.setRequestBody(data);
        try {
            // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            int statusCode=httpClient.executeMethod(postMethod);
                             
            // 获得登陆后的 Cookie
            Cookie[] cookies = httpClient.getState().getCookies();
            StringBuffer tmpcookies = new StringBuffer();
            for (Cookie c : cookies) {
                tmpcookies.append(c.toString() + ";");
                System.out.println("cookies = "+c.toString());
            }
            if(statusCode==302 || statusCode == 200){//重定向到新的URL
                System.out.println("模拟登录成功");
                // 进行登陆后的操作
                GetMethod getMethod = new GetMethod(dataUrl);
                // 每次访问需授权的网址时需带上前面的 cookie 作为通行证
                getMethod.setRequestHeader("cookie", tmpcookies.toString());
                // 你还可以通过 PostMethod/GetMethod 设置更多的请求后数据
                // 例如，referer 从哪里来的，UA 像搜索引擎都会表名自己是谁，无良搜索引擎除外
                postMethod.setRequestHeader("Referer", "http://localhost:8080");
                postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
                httpClient.executeMethod(getMethod);
                // 打印出返回数据，检验一下是否成功
                String text = getMethod.getResponseBodyAsString();
                System.out.println(text);
            }
            else {
                System.out.println("登录失败");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
