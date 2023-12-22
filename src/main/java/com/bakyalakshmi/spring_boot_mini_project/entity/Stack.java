package com.bakyalakshmi.spring_boot_mini_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Stacks")
public class Stack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String environment;
    @Builder.Default
    @Column(columnDefinition = "boolean default true")
    private Boolean availability = true;
}


