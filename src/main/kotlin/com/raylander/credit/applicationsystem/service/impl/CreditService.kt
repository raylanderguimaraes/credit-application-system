package com.raylander.credit.applicationsystem.service.impl

import com.raylander.credit.applicationsystem.entity.Credit
import com.raylander.credit.applicationsystem.repository.CreditRepository
import com.raylander.credit.applicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*


@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return creditRepository.findAllByCustomer(customerId)
    }


    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode is not found ")
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin ")
    }
}