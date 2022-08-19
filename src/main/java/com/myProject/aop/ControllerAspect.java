package com.myProject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author ZhangYijing
 * @Description controller层切面
 * @Date 2022/4/28
 */
@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Pointcut("execution(public * com.myProject.controller..*.*(..))")
    public void checkControllerMethodPointcut() {
    }

    @Before("checkControllerMethodPointcut()")
    public void doBeforeControllerMethod(JoinPoint joinPoint) {
        this.preHandle(joinPoint);
    }

    @AfterReturning("checkControllerMethodPointcut()")
    public void doAfterControllerMethod(JoinPoint joinPoint) {
        this.afterHandle(joinPoint);
    }

    private void afterHandle(JoinPoint joinPoint) {
        log.info("执行结束");
    }

    private void preHandle(JoinPoint joinPoint) {
        // url和访问源ip
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        // methodName
        Class<?> targetClass = joinPoint.getTarget().getClass();
        String methodName = targetClass.getName() + "#" + joinPoint.getSignature().getName();
        // 入参
        Object[] args = joinPoint.getArgs();
        Content content = new Content(url, ip, methodName, args);
        log.info("Request:{}", content);
//         Method method = signature.getMethod();
//         Class<?>[] parameterTypes = method.getParameterTypes();
//         Parameter[] parameters = method.getParameters();
//         log.info("执行方法前日志" + method.getName());
//         log.info("执行方法前日志方法参数类型" + Arrays.toString(parameters));
    }

    private class Content {
        private final String url;
        private final String ip;
        private final String method;
        private final Object[] args;

        public Content (String url, String ip, String method, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.method = method;
            this.args = args;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", method='" + method + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}