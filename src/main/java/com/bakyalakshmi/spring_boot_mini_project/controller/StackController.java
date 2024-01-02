package com.bakyalakshmi.spring_boot_mini_project.controller;

import com.bakyalakshmi.spring_boot_mini_project.dto.StackDto;
import com.bakyalakshmi.spring_boot_mini_project.dto.UsageHistoryDto;
import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import com.bakyalakshmi.spring_boot_mini_project.service.StackService;
import com.bakyalakshmi.spring_boot_mini_project.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StackController {

    @Autowired
    private StackService stackService;
    @Autowired
    private UsageHistoryService usageHistoryService;

    @PostMapping("/stacks")
    public Stack saveStack(@RequestBody Stack stack) {
        return stackService.saveStack(stack);
    }

    @PutMapping("/stacks/{id}")
    public Stack updateStack(@PathVariable("id") Long stackId , @RequestBody Stack stack){

        Stack foundStack = stackService.findStackById(stackId);

        if(Objects.nonNull(stack.getName()) && !"".equals(stack.getName())){
            foundStack.setName(stack.getName());
        }

        if(Objects.nonNull(stack.getEnvironment()) && !"".equals(stack.getEnvironment())) {
            foundStack.setEnvironment(stack.getEnvironment());
        }

        return stackService.saveStack(foundStack);
    }

    @GetMapping("/stacks")
    public List<StackDto> fetchStackList(){
        return stackService.findAllStacksWithHistory();
    }

    @GetMapping("/stacks/{id}")
    public Stack findStackById(@PathVariable("id") Long stackId) {
        return stackService.findStackById(stackId);
    }


    @PutMapping("stack/release/{id}")

    public void releaseStack( @PathVariable("id") Long stackId){

        UsageHistory usageHistory =   usageHistoryService.fetchActiveUsageHistoryByStackId(stackId);

        UsageHistoryDto usageHistoryDto = new UsageHistoryDto();

        usageHistoryDto.setId(usageHistory.getId());
        usageHistoryDto.setStackId(usageHistory.getStack().getId());
        usageHistoryDto.setUserEmail(usageHistory.getUserEmail());
        usageHistoryDto.setFrontendBranch(usageHistory.getFrontendBranch());
        usageHistoryDto.setBackendBranch(usageHistory.getBackendBranch());
        usageHistoryDto.setStartedAt(usageHistory.getStartedAt());
        usageHistoryDto.setEndedAt(LocalDateTime.now());

        usageHistoryService.saveUsageHistory(usageHistoryDto);

        stackService.releaseStack(stackId);
    }
}
