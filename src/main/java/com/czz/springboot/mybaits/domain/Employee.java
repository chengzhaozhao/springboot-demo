package com.czz.springboot.mybaits.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 4060474912432126733L;
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private Integer gender;

    /**
     *
     */
    private Integer dId;
}

