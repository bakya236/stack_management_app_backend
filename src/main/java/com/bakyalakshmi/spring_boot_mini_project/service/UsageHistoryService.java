package com.bakyalakshmi.spring_boot_mini_project.service;

import com.bakyalakshmi.spring_boot_mini_project.dto.UsageHistoryDto;
import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface UsageHistoryService {

    public UsageHistory saveUsageHistory(UsageHistoryDto usageHistoryDto);

    List<UsageHistory> fetchUsageHistoryByStackId(int stackId);
}
