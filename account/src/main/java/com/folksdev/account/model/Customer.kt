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

    ){
    override fun equals(other: Any?): Boolean { // değerleri eşit mi diye bakıyor.
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (id != other.id) return false
        if (name != other.name) return false
        if (surname != other.surname) return false
        return accounts == other.accounts
    }

    override fun hashCode(): Int { //özel bir algoritma
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (surname?.hashCode() ?: 0)
        return result
    }
}
