package com.bakyalakshmi.spring_boot_mini_project.repository;

import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack, Integer> {

}
