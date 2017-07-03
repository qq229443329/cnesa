package com.cnesa.authority.filter;

import com.cnesa.authority.model.CurrentUser;
import com.cnesa.common.utils.TokenUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by shangpeibao on 16/12/20.
 *
 * 用户登录验证
 */
public class ControllerFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Access-Token");
        if (!StringUtils.hasLength(token)) {
            return false;
        }
        Map<String, Object> map = TokenUtil.getMapByToken(token);
        CurrentUser.setId(map.get("uid").toString());
        CurrentUser.setResources((List<String>)map.get("resources"));
        CurrentUser.setToken(token);
        CurrentUser.setUsername(map.get("email").toString());
        return map != null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
