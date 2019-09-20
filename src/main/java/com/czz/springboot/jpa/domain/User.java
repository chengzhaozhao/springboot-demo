package com.czz.springboot.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-20 9:28
 */
@Data
@Entity
@Table(name = "tbl_user")
//是因为在实体类中 发现有字段为null，在转化成json的时候，fasterxml.jackson将对象转换为json报错
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements Serializable {
    private static final long serialVersionUID = 4494696609094492618L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "last_name",length = 50)
    private String lastName;
    @Column(name = "email",length = 20)
    private String email;
}
