package com.bakyalakshmi.spring_boot_mini_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigInteger;
import java.time.LocalDateTime;

//@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsageHistoryDto {

    private Long id;
    private String frontendBranch;
    private String backendBranch;
    private String userEmail;
    private Long stackId;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;


}
