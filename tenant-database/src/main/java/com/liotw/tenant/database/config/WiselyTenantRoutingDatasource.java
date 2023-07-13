package com.liotw.tenant.database.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author jjl
 * @date 2023/7/12
 */
@Component
public class WiselyTenantRoutingDatasource extends AbstractRoutingDataSource {
    private final WiselyTenantIdResolver wiselyTenantIdResolver;

    public WiselyTenantRoutingDatasource(WiselyTenantIdResolver wiselyTenantIdResolver) {
        this.wiselyTenantIdResolver = wiselyTenantIdResolver;
        setDefaultTargetDataSource(createDatabase("jdbc:mysql://127.0.0.1:3306/schema", "root", "root"));
        HashMap<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("companya", createDatabase("jdbc:mysql://127.0.0.1:3306/companya", "root", "root"));
        targetDataSources.put("companyb", createDatabase("jdbc:mysql://127.0.0.1:3306/companyb", "root", "root"));
        setTargetDataSources(targetDataSources);
    }

    @Override
    protected String determineCurrentLookupKey() {
        return wiselyTenantIdResolver.resolveCurrentTenantIdentifier();
    }

    private DataSource createDatabase(String databaseUrl, String username, String password) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url(databaseUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
