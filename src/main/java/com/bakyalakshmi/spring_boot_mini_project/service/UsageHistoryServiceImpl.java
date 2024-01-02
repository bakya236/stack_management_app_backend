package com.bakyalakshmi.spring_boot_mini_project.service;

import com.bakyalakshmi.spring_boot_mini_project.dto.UsageHistoryDto;
import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import com.bakyalakshmi.spring_boot_mini_project.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UsageHistoryServiceImpl  implements UsageHistoryService {

    @Autowired
    private UsageHistoryRepository usageHistoryRepository;


    @Override
    public List<UsageHistory> fetchUsageHistoryByStackId(Long stackId) {
        return usageHistoryRepository.findAllByStackId(stackId);
    }

    @Override
    public UsageHistory fetchActiveUsageHistoryByStackId(Long stackId) {
        return usageHistoryRepository.findActiveUsageHistoryByStackId(stackId);
    }

    @Override
    public UsageHistory saveUsageHistory(UsageHistoryDto usageHistoryDto) {

        UsageHistory usageHistory = new UsageHistory();

        usageHistory.setFrontendBranch(usageHistoryDto.getFrontendBranch());
        usageHistory.setBackendBranch(usageHistoryDto.getBackendBranch());
        usageHistory.setUserEmail(usageHistoryDto.getUserEmail());
        usageHistory.setStartedAt(usageHistoryDto.getStartedAt());
        usageHistory.setEndedAt(usageHistoryDto.getEndedAt());
        usageHistory.setId(usageHistoryDto.getId());

        Stack stack = new Stack();
        stack.setId(usageHistoryDto.getStackId());
        usageHistory.setStack(stack);

        return usageHistoryRepository.save(usageHistory);
    }

}
