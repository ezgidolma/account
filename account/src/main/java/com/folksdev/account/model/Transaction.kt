package com.folksdev.account.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Transaction(

    @Id
    @GeneratedValue(generator = "UUID") //tahmin edilemeyen ıd olsun.uuid hascode üretilir istek üretilirse her seferinde farklı id oluşturur
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") //uuidyi çalıştıracak kod
    val id: String?,// soru işareti boş da olabilir demek

    val transactionType: TransactionType ?= TransactionType.INITAL,
    val amount: BigDecimal?,//parasal işlemlerde BigDecimal ile daha çok veri elde tutulabilir
    val transactionDate: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account
) {


    constructor(amount: BigDecimal,  account: Account) : this(
        id = null,
        amount = amount,
        transactionDate = LocalDateTime.now(),
        transactionType = TransactionType.INITAL,
        account = account
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Transaction

        if (id != other.id) return false
        if (transactionType != other.transactionType) return false
        if (amount != other.amount) return false
        if (transactionDate != other.transactionDate) return false
        if (account != other.account) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (transactionType?.hashCode() ?: 0)
        result = 31 * result + (amount?.hashCode() ?: 0)
        result = 31 * result + (transactionDate?.hashCode() ?: 0)
        return result
    }
}
enum class TransactionType{
    INITAL,TRANSFER
}