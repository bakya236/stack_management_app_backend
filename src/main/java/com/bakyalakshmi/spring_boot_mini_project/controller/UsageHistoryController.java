package com.bakyalakshmi.spring_boot_mini_project.controller;

import com.bakyalakshmi.spring_boot_mini_project.dto.UsageHistoryDto;
import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import com.bakyalakshmi.spring_boot_mini_project.service.StackService;
import com.bakyalakshmi.spring_boot_mini_project.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsageHistoryController {

    @Autowired
    UsageHistoryService usageHistoryService;

    @Autowired
    StackService stackService;

    @GetMapping("/usagehistory/{id}")
    private List<UsageHistory> fetchUsageHistoryByStackId(@PathVariable("id") Long stackId){
        return usageHistoryService.fetchUsageHistoryByStackId(stackId);
    }

    @PostMapping("/stack/use")
    public UsageHistory useStack(@RequestBody UsageHistoryDto usageHistoryDto){
        stackService.changeStackToNotAvailable(usageHistoryDto.getStackId());
        return usageHistoryService.saveUsageHistory(usageHistoryDto);
    }



}
