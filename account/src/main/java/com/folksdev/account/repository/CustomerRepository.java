package com.folksdev.account.repository;

import com.folksdev.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
