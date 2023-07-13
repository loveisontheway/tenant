package com.liotw.tenant.partition.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author jjl
 * @date 2023/7/12
 */
@Component
public class TenantIdInterceptor implements HandlerInterceptor {

    private final WiselyTenantIdResolver tenantIdResolver;

    public TenantIdInterceptor(WiselyTenantIdResolver tenantIdResolver) {
        this.tenantIdResolver = tenantIdResolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        tenantIdResolver.setCurrentTenant(request.getHeader("x-tenant-id"));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
