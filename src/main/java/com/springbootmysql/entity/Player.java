package com.springbootmysql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Player {

    @Id @GeneratedValue
    private Long number;

    @Column
    private String name;

    @Column
    private Long goal;

    @Column
    private Long assist;

    public Player()
    {

    }

    public Player( String name, Long goal, Long assist) {
        this.name = name;
        this.goal = goal;
        this.assist = assist;
    }
}
