package com.tongkn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by tongkn on 2017/4/10.
 */
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;
}
