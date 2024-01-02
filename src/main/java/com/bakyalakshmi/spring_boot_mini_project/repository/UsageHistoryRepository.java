package com.bakyalakshmi.spring_boot_mini_project.repository;

import com.bakyalakshmi.spring_boot_mini_project.dto.UsageHistoryDto;
import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Long> {

    // getting all the usages by sorting by the
    @Query("SELECT u FROM UsageHistory u WHERE u.stack.id = :stackId ORDER BY u.startedAt DESC")
    List<UsageHistory> findAllByStackId(@Param("stackId") Long stackId);

    @Query("SELECT u FROM UsageHistory u WHERE u.stack.id = :stackId AND u.endedAt IS NULL ORDER BY u.startedAt DESC")
    UsageHistory findActiveUsageHistoryByStackId(@Param("stackId") Long stackId);
}

