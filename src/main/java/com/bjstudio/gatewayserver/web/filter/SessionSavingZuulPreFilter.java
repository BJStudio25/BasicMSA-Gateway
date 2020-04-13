package com.bjstudio.gatewayserver.web.filter;

import javax.servlet.http.HttpSession;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * SessionSavingZuulPreFilter
 */
@RequiredArgsConstructor
@Component
public class SessionSavingZuulPreFilter extends ZuulFilter {

    private final SessionRepository sessionRepository;

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpSession httpSession = context.getRequest().getSession();
        Session session = sessionRepository.findById(httpSession.getId());

        context.addZuulRequestHeader("Cookie", "SESSION="+httpSession.getId());
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return "pre";
    }
    
}