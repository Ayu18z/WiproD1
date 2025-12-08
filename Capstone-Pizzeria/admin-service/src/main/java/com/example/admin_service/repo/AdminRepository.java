package com.example.admin_service.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.admin_service.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // return list to avoid NonUniqueResultException if DB had duplicates
    List<Admin> findByUsername(String username);
}
