package com.bakyalakshmi.spring_boot_mini_project.service;

import com.bakyalakshmi.spring_boot_mini_project.dto.StackDto;
import com.bakyalakshmi.spring_boot_mini_project.entity.Stack;
import org.springframework.stereotype.Component;
import java.math.BigInteger;
import java.util.List;

@Component
public interface StackService {

   public Stack saveStack(Stack stack);

   public Stack findStackById(Long stackId);

   void releaseStack(Long stackId);

   void changeStackToNotAvailable(Long stackId);

    List<StackDto> findAllStacksWithHistory();
}
