package com.bakyalakshmi.spring_boot_mini_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @NonNull
    private String frontEndBranch;
    @NonNull
    private String backEndBranch;
    @NonNull
    private String userEmail;

    @ManyToOne
    @JoinColumn(name = "stack_id")
    private Stack stack;

}
