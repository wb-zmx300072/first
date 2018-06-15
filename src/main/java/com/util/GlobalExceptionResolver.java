/*
package com.util;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * @Description：TODO
 * @Author wb-zmx300072 2018/3/21 14:14
 *//*

@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         @Nullable Object o, Exception e) {
        httpServletResponse.reset();
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        httpServletResponse.setCharacterEncoding("UTF-8"); //避免乱码
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        ModelAndView modelAndView = new ModelAndView(new FastJsonJsonView());
        HandlerMethod  handlerMethod = (HandlerMethod)o;
        MethodParameter[]  methodParameters = handlerMethod.getMethodParameters();
        StringBuffer sb = new StringBuffer();
        if(methodParameters!= null && methodParameters.length>0){
            for(MethodParameter parameter :methodParameters){
                sb.append(parameter.getParameter());
            }
        }
        logger.error("系统异常url {} ,param : {}" + httpServletRequest.getRequestURI() ,sb.toString(),e);
        modelAndView.addObject("success","false");
        modelAndView.addObject("errMsg","系统异常");
        modelAndView.addObject("content",e.toString());
        return modelAndView;
    }
}
*/
