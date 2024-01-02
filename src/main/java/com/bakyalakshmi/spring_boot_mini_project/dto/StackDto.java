package com.bakyalakshmi.spring_boot_mini_project.dto;


import com.bakyalakshmi.spring_boot_mini_project.entity.UsageHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@DynamicInsert
@DynamicUpdate
public class StackDto {

        private Long id;
        private String name;
        private String environment;
        private Boolean availability;
        private UsageHistory usageHistory;
}
