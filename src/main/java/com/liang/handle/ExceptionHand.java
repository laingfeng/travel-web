package com.liang.handle;

import com.liang.beans.ExceptionInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHand {


    @ExceptionHandler(Myexception.class)
  //  @ResponseBody
    public String handMyException(HttpServletRequest httpServletRequest, Myexception e, Model model){
        ExceptionInfo<String> r=new ExceptionInfo();
        r.setMessage(e.getMessage());
        r.setCode(ExceptionInfo.error);
        r.setUrl(httpServletRequest.getRequestURI());
        r.setData("caozuo chucuo");
        model.addAttribute("exception",r);
        return "error";
    }
}
