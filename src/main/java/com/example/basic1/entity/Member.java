package com.example.basic1.entity;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

}
