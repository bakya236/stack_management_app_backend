package com.bakyalakshmi.spring_boot_mini_project.service;

import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StackService {

   public Stack saveStack(Stack stack);

   public Stack findStackById(int stackId);

   public List<Stack> fetchStackList();

   void releaseStack(int stackId);

   void changeStackToNotAvailable(int stackId);
}
