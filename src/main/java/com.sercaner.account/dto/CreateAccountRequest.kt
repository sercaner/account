package com.sercaner.account.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class CreateAccountRequest(
    @field:NotBlank(message = "CustomerId must not be empty")
    val customerId: String,
    @field:Min(0,  message = "Initial credit must be greater than or equal to 0")
    val initialCredit: BigDecimal
)
