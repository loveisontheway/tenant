package com.liotw.tenant.schema.config;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @author jjl
 * @date 2023/7/12
 */
@Component
public class WiselyTenantIdResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {

    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<String>();

    public void setCurrentTenant(String currentTenant) {
        CURRENT_TENANT.set(currentTenant);
    }

    @Override
    public String resolveCurrentTenantIdentifier() {
        return Optional.ofNullable(CURRENT_TENANT.get()).orElse("schema");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }

}
