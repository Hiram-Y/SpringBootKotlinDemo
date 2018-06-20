package com.spring.demo

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.*

@Entity // 告诉Hibernate依据这个类创建一个表
@Table(name = "customers")
class Customers{

    @Id //主键
    @GeneratedValue(strategy = GenerationType.AUTO) //自增长
    @Column(name = "id")
    var id:Int = 0

    @Column(name = "name")
    var name : String? = null

    @Column(name = "address")
    var address : String? = null

    @Column(name = "city")
    var city : String? = null

    @Column(name = "age")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    var age : Int = 0

    @Column(name = "love")
    var love : String? = null
}