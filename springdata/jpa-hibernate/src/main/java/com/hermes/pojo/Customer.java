package com.hermes.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {


    /**
     * IDENTITY：自增，《MySQL
     * SEQUENCE：序列，Oracle
     * TABLE：JPA提供的机制，通过一张数据库表的形式 完成主键分配
     * AUTO：程序自动选择
     */
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_address")
    private String custAddress;
}