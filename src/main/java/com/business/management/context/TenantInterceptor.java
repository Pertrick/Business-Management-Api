package com.business.management.context;

import com.business.management.service.TenantService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    @Autowired
    private TenantService tenantService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Extract tenant ID from the request (e.g., header, URL, etc.)
        String tenantId = request.getHeader("X-Tenant-ID");

        if (tenantId == null) {
            throw new IllegalArgumentException("Tenant ID is missing");
        }

        // Set the tenant context
        TenantContext.setTenantId(Long.valueOf(tenantId));

        // Proceed with the request
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Clear the tenant context after request processing
        TenantContext.clear();
    }
}

