package com.bakyalakshmi.spring_boot_mini_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usage_history")
public class UsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String frontendBranch;
    private String backendBranch;
    private String userEmail;

    @ManyToOne
    @JoinColumn(name = "stack_id", referencedColumnName = "id")
    private Stack stack;

    @CreationTimestamp
    private LocalDateTime startedAt;

    @Column(columnDefinition = "Datetime default null")
    private LocalDateTime endedAt;

}
