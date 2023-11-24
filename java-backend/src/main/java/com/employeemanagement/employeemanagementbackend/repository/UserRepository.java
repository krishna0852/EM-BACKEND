package com.employeemanagement.employeemanagementbackend.repository;

import com.employeemanagement.employeemanagementbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{



}
