package com.bakyalakshmi.spring_boot_mini_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsageHistoryDto {

    private String frontEndBranch;
    private String backEndBranch;
    private String userEmail;
    private int stackId;

}
