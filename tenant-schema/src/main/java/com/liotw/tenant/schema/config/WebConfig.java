package com.liotw.tenant.schema.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jjl
 * @date 2023/7/12
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final TenantIdInterceptor tenantIdInterceptor;

    public WebConfig(TenantIdInterceptor tenantIdInterceptor) {
        this.tenantIdInterceptor = tenantIdInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantIdInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
