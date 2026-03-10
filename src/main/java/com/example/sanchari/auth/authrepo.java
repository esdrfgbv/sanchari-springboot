package com.example.sanchari.auth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authrepo extends JpaRepository<authmodel, Long> {
    List<authmodel> findAll();

    authmodel findByUsername(String username);
}
