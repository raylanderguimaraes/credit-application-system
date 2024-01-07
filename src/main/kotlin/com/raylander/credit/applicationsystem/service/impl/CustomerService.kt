package com.raylander.credit.applicationsystem.service.impl

import com.raylander.credit.applicationsystem.entity.Customer
import com.raylander.credit.applicationsystem.repository.CustomerRepository
import com.raylander.credit.applicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService  {
    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow(){
            throw RuntimeException("Id $id is not found")
        }
    }

    override fun deleteById(id: Long) {
        this.customerRepository.deleteById(id)
    }

}
