package com.folksdev.account.model

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.ManyToAny
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany


@Entity
data class Account(
        @Id
        @GeneratedValue(generator = "UUID") //tahmin edilemeyen ıd olsun.uuid hascode üretilir istek üretilirse her seferinde farklı id oluşturur
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") //uuidyi çalıştıracak kod
        val id: String?,// soru işareti boş da olabilir demek
        val balance:BigDecimal?=BigDecimal.ZERO,
        val creationDate: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY , cascade = [CascadeType.ALL])
        @JoinColumn(name = "customer_id", nullable = false)
        val customer : Customer?,

        @OneToMany(mappedBy = "account" , fetch = FetchType.LAZY)
        val transaction: Set<Transaction>?
)
{

}
