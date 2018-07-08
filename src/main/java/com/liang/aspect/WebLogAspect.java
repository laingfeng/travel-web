package com.liang.aspect;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;



 // Web层日志切面

@Aspect
@Order(1)
@Component
public class WebLogAspect {

    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(getClass());
    ThreadLocal<Long> startTime =new ThreadLocal();

    @Pointcut("execution(public * com.liang.web..*.*(..))")
    public  void weblog(){
    }

   @Before("weblog()")
    public  void debefor(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
      ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      HttpServletRequest request= requestAttributes.getRequest();
      logger.info("url:"+request.getRequestURI());
      logger.info("IP:"+request.getRemoteHost());
      logger.info("http_method:"+request.getMethod());
      logger.info("class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
      logger.info("Args:"+Arrays.toString(joinPoint.getArgs()));

    }




    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    @AfterReturning(returning = "ret",pointcut = "weblog()")
    public  void  doAfterreturning(Object ret) throws Exception
    {
        logger.info("RESPONSE : " + ret);
        //  logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

}

