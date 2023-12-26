package com.bakyalakshmi.spring_boot_mini_project.controller;

import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import com.bakyalakshmi.spring_boot_mini_project.service.StackService;
import com.bakyalakshmi.spring_boot_mini_project.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class StackController {

    @Autowired
    private StackService stackservice;

    @PostMapping("/stacks")
    public Stack saveStack(@RequestBody Stack stack) {
        return stackservice.saveStack(stack);
    }

    @PutMapping("/stacks/{id}")
    public Stack updateStack(@PathVariable("id") int stackId , @RequestBody Stack stack){

        Stack foundStack = stackservice.findStackById(stackId);

        if(Objects.nonNull(stack.getName()) && !"".equals(stack.getName())){
            foundStack.setName(stack.getName());
        }

        if(Objects.nonNull(stack.getEnvironment()) && !"".equals(stack.getEnvironment())) {
            foundStack.setEnvironment(stack.getEnvironment());
        }

        return stackservice.saveStack(foundStack);
    }

    @GetMapping("/stacks")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Stack> fetchStackList() {
        return stackservice.fetchStackList();
    }

    @GetMapping("/stacks/{id}")
    public Stack findStackById(@PathVariable("id") int stackId) {
        return stackservice.findStackById(stackId);
    }

    @PutMapping("stack/release/{id}")
    public void releaseStack( @PathVariable("id") int stackId){
         stackservice.releaseStack(stackId);
    }
}
