package com.raylander.credit.applicationsystem.service


import com.raylander.credit.applicationsystem.entity.Customer
import java.util.UUID


interface ICustomerService {
    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long): Customer
}