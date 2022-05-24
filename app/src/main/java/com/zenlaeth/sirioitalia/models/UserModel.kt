package com.zenlaeth.sirioitalia.models

import java.time.LocalDate

data class UserModel(
    var id: Int,
    var firstName: String,
    var lastName: String,
    var fullName: String,
    var email: String,
    var address: Address,
    var birthDate: Any,
    var phoneNumber: Any,
    var role: Role,
    var orders: List<Any>
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