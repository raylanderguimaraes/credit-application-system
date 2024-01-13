package com.raylander.credit.applicationsystem.dto

import com.raylander.credit.applicationsystem.entity.Credit
import com.raylander.credit.applicationsystem.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid Input") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    @field:Max(48, message = "The number of installments cannot exceed 48") val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid Input") val customerId: Long,
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)

    )

}
