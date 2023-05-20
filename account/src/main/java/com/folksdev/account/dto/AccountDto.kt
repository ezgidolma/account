package com.folksdev.account.dto

import com.folksdev.account.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.print.attribute.standard.DateTimeAtCreation
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local

data class AccountDto(
    val id:String?,
    val balance: BigDecimal?,
    val creationDate: LocalDateTime?,
    val customer:AccountCustomerDto?,
    val transaction: Set<TransactionDto>?
)
