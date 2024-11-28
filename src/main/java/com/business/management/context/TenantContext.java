package com.business.management.context;

import org.springframework.stereotype.Component;

@Component
public class TenantContext {

    private static final ThreadLocal<Long> tenantContext = new ThreadLocal<>();

    public static void setTenantId(Long tenantId) {
        tenantContext.set(tenantId);
    }

    public static Long getTenantId() {
        return tenantContext.get();
    }

    public static void clear() {
        tenantContext.remove();
    }
}
