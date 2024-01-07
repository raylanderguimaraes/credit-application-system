package com.raylander.credit.applicationsystem.service

import com.raylander.credit.applicationsystem.entity.Credit
import java.util.*

interface ICreditService {
    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID): Credit
}