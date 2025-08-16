package com.virtual.thread.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtual.thread.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByRegion(String region);
}
