package com.business.management.repository;

import com.business.management.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository  extends JpaRepository<Tenant, Long> {
    Optional<Tenant> findByDomain(String domain);

    Optional<Tenant> findByName(String name);
}
