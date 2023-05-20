package com.folksdev.account.dto

import com.folksdev.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
    val id: String?,// soru işareti boş da olabilir demek

    val transactionType: TransactionType?= TransactionType.INITAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?

    )
