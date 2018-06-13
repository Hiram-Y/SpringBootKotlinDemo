package com.spring.demo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
class Customers{

    @Id
    @Column(name = "id")
    var id:Int = 0

    @Column(name = "name")
    var name : String? = null

    @Column(name = "address")
    var address : String? = null

    @Column(name = "city")
    var city : String? = null

    @Column(name = "age")
    var age : Int = 0

    @Column(name = "love")
    var love : String? = null
}