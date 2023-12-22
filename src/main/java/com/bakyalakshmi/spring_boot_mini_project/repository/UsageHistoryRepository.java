package com.bakyalakshmi.spring_boot_mini_project.repository;

import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Integer> {

    @Query("SELECT u FROM UsageHistory u WHERE u.stack.id = :stackId")
    List<UsageHistory> findAllByStackId(@Param("stackId") int stackId);

}

