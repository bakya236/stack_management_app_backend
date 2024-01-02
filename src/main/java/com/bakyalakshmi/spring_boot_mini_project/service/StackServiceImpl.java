package com.bakyalakshmi.spring_boot_mini_project.service;

import com.bakyalakshmi.spring_boot_mini_project.dto.StackDto;
import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import com.bakyalakshmi.spring_boot_mini_project.repository.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class StackServiceImpl implements StackService{

    @Autowired
    private StackRepository stackRepository;

    @Autowired
    private UsageHistoryService usageHistoryService;

    @Override
    public Stack saveStack(Stack stack) {
        return stackRepository.save(stack);
    }

    @Override
    public Stack findStackById(Long stackId) {

        return stackRepository.findById(stackId).get();
    }

    @Override
    public void changeStackToNotAvailable(Long stackId) {

        Stack foundStack = findStackById(stackId);

        if( foundStack.getAvailability()) {
            foundStack.setAvailability(false);
        }
        stackRepository.save(foundStack);
    }

    @Override
    public List<StackDto> findAllStacksWithHistory() {
        List<Object[]> arrayOfArrays = stackRepository.fetchAllStacksWithHistory();
        List<StackDto> listOfStacks = new ArrayList<>();

        for (Object[] array : arrayOfArrays) {
            StackDto stackDto = new StackDto();
            stackDto.setId((long)array[0]);
            stackDto.setName((String) array[1]);
            stackDto.setEnvironment((String) array[2]);
            stackDto.setAvailability((Boolean) array[3]);

            UsageHistory usageHistory = new UsageHistory();

            long stackId = 0;
            if(array[4] != null){
                stackId = (long) array[4];
            }
            usageHistory.setId(stackId);
            usageHistory.setFrontendBranch((String) array[5]);
            usageHistory.setBackendBranch((String) array[6]);
            usageHistory.setUserEmail((String) array[7]);

            stackDto.setUsageHistory(usageHistory);
            listOfStacks.add(stackDto);
        }
        return listOfStacks;
    }

    @Override
    public void releaseStack(Long stackId) {

        Stack foundStack = findStackById(stackId);

        if( foundStack.getAvailability() == false) {
            foundStack.setAvailability(true);
        }

//       usageHistoryService.fetchUsageHistoryByStackId(stackId);
        // Spring assumes certain methods are available when using its features like Spring Data JPA
        // not necessarily put methods
        stackRepository.save(foundStack);
    }

}
