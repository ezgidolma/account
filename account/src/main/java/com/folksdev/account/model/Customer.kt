package com.folksdev.account.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Customer(

    @Id
    @GeneratedValue(generator = "UUID") //tahmin edilemeyen ıd olsun.uuid hascode üretilir istek üretilirse her seferinde farklı id oluşturur
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") //uuidyi çalıştıracak kod
    val id:String?,

    val name: String?,
    val surname: String?,

    @OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY)
    val accounts: Set<Account>?

    )
