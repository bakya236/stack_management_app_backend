package com.bakyalakshmi.spring_boot_mini_project.service;

import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import com.bakyalakshmi.spring_boot_mini_project.repository.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Stack findStackById(int stackId) {

        return stackRepository.findById(stackId).get();
    }

    @Override
    public List<Stack> fetchStackList() {
        return stackRepository.findAll();
    }

    @Override
    public void changeStackToNotAvailable(int stackId) {

        Stack foundStack = findStackById(stackId);

        if( foundStack.getAvailability()) {
            foundStack.setAvailability(false);
        }
        stackRepository.save(foundStack);
    }

    @Override
    public void releaseStack(int stackId) {

        Stack foundStack = findStackById(stackId);

        if( foundStack.getAvailability() == false) {
            foundStack.setAvailability(true);
        }
        // Spring assumes certain methods are available when using its features like Spring Data JPA
        // not necessarily put methods
        stackRepository.save(foundStack);
    }

}
