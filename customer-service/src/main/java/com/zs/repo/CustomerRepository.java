package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
