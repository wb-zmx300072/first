package com.excelib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoController  {

    @RequestMapping(value = {"/"}, method = {RequestMethod.HEAD})
    public String head() {
        return "go.jsp";
    }

    @RequestMapping(value = {"/index","/"}, method = {RequestMethod.GET})
    public String index(Model model) throws Exception {
        //返回msg参数
        System.out.println(System.getProperty("catalina.home"));
        System.out.println(this.getClass().getResource("/"));
        model.addAttribute ( "msg", "GO GO GO GO !!!" );
        return "go.jsp";
    }
    @RequestMapping(value = "/getData")
    @ResponseBody
    public String json(){
        return "    success!~~~~~~~success!~~~~~~~success!~~~~~~~~   ";
    }

}

