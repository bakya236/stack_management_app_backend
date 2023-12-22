package com.bakyalakshmi.spring_boot_mini_project.service;

import com.bakyalakshmi.spring_boot_mini_project.dto.UsageHistoryDto;
import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import com.bakyalakshmi.spring_boot_mini_project.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsageHistoryServiceImpl  implements UsageHistoryService {

    @Autowired
    private UsageHistoryRepository usageHistoryRepository;


    @Override
    public List<UsageHistory> fetchUsageHistoryByStackId(int stackId) {
        return usageHistoryRepository.findAllByStackId(stackId);
    }

    @Override
    public UsageHistory saveUsageHistory(UsageHistoryDto usageHistoryDto) {

        UsageHistory usageHistory = new UsageHistory();
        usageHistory.setFrontEndBranch(usageHistoryDto.getFrontEndBranch());
        usageHistory.setBackEndBranch(usageHistoryDto.getBackEndBranch());
        usageHistory.setUserEmail(usageHistoryDto.getUserEmail());

        Stack stack = new Stack();
        stack.setId(usageHistoryDto.getStackId());
        usageHistory.setStack(stack);

        return usageHistoryRepository.save(usageHistory);
    }

}
