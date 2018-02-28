package com.excelib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller // @Controller 代表本Java类是controller控制层
public class Login {

    /**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     * @param username
     *            用户名，一定要对应着表单的name才行
     * @param password
     *            用户密码，也应该对应表单的数据项
     * @param model
     *            一个域对象，可用于存储数据值
     * @return
     */
    @RequestMapping("/login") // @RequestMapping 注解可以用指定的URL路径访问本控制层
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Model model, HttpSession httpSession, HttpServletRequest request) {
        if (username.equals("admin") && password.equals("admin")) {
            model.addAttribute("username", username);
            model.addAttribute ( "msg", "login success !!!" );
            httpSession.setAttribute("temp_user",username);
            return "go.jsp";
        } else {
            model.addAttribute("username", username);
            return "login.jsp";
        }
    }

}
