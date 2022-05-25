package com.zenlaeth.sirioitalia.models

import java.time.LocalDate

data class NewUser(
    var firstName: String,
    var lastName: String,
    var email: String,
    var passwordHash: String,
    var address: Address,
    var birthDate: Any,
    var phoneNumber: Any,
    var role: Role
)

data class Address(
    var city: String,
    var streetName: String,
    var streetNumber: String,
    var streetType: String,
    var zipCode: String
)

data class Role(
    var id: Int,
)

