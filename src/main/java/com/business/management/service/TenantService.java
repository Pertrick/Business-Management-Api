package com.business.management.service;

import com.business.management.entity.Tenant;
import com.business.management.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    // Finds tenant based on email domain (e.g., user@company1.com -> tenant_id for company1)
    public Tenant getTenantForEmail(String email) {
        String domain = email.split("@")[1];  // Get domain part of the email
        return tenantRepository.findByDomain(domain).orElseThrow(() -> new RuntimeException("Tenant not found"));
    }
}
