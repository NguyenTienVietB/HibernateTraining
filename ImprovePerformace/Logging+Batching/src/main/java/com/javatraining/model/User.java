package com.javatraining.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;


@Data
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserProfile userProfile;


}