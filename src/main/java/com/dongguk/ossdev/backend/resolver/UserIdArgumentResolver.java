package com.dongguk.ossdev.backend.resolver;

import com.dongguk.ossdev.backend.annotation.UserId;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("supportsParameter = {}", parameter.getParameterType().equals(String.class) &&
                parameter.hasParameterAnnotation(UserId.class));
        // parameterType 이 String && @UserId 사용
        return parameter.getParameterType().equals(String.class)
                && parameter.hasParameterAnnotation(UserId.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        log.info("resolveArgument = {}", Long.valueOf(((HttpServletRequest) webRequest).getAttribute("USER_ID").toString()));
        return Long.valueOf(((HttpServletRequest) webRequest).getAttribute("USER_ID").toString());
    }
}
