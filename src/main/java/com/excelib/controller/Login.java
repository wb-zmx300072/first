package com.excelib.controller;

import com.alibaba.fastjson.JSONObject;
import com.excelib.vo.UserVo;
import com.util.CookieUtil;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController // @Controller 代表本Java类是controller控制层
public class Login {

    private  static Logger logger = LoggerFactory.getLogger(Login.class);

    /**
     * @param username 用户名，一定要对应着表单的name才行
     * @param password 用户密码，也应该对应表单的数据项
     * @param model    一个域对象，可用于存储数据值
     * @return
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     */
    @RequestMapping("/login") // @RequestMapping 注解可以用指定的URL路径访问本控制层
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession httpSession, HttpServletRequest request,
                        HttpServletResponse response) {
        int i =0;
        int j = 1/i;

        UserVo user = new UserVo();
        user.setAddress("杭州");
        user.setAge(20);
        user.setUserName("张三");
        CookieUtil.setLoginCookie(response,httpSession.getId());
        httpSession.setAttribute("temp_user", JSONObject.toJSONString(user));
//        redisPoolUtil.setex(httpSession.getId(), CookieUtil.LOGIN_SESSION_TIME, JSONObject.toJSONString(user));
        return "go";
/*        if (username.equals("admin") && password.equals("admin")) {
            model.addAttribute("username", username);
            model.addAttribute ( "msg", "login success !!!" );
            httpSession.setAttribute("temp_user",username);
            return "go.jsp";
        } else {
            model.addAttribute("username", username);
            return "login.jsp";
        }*/
    }

    @RequestMapping("/getUser") // @RequestMapping 注解可以用指定的URL路径访问本控制层
    public UserVo getUserInfo( HttpSession httpSession) {
//        String token = CookieUtil.getLoginCookie(request);
//        String jsonUser = redisPoolUtil.get(loginCookieVal);
        String jsonUser = (String)httpSession.getAttribute("temp_user");
        if(StringUtils.isNotBlank(jsonUser)){
            try {
                UserVo userVo = JSONObject.parseObject(jsonUser,UserVo.class);
                return userVo;
            } catch (Exception e) {
                logger.error("解析用户信息失败");
            }
        }else{
            logger.error("未找到用户信息");
        }
        return null;
    }


    @RequestMapping("/logout") // @RequestMapping 注解可以用指定的URL路径访问本控制层
    public String logout( HttpSession httpSession) {
//        String token = CookieUtil.getLoginCookie(request);
//        String jsonUser = redisPoolUtil.get(loginCookieVal);
        httpSession.removeAttribute("remp_user");

        return "OK";
    }

}
