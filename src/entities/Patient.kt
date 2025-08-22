package entities

import enum.Gender

class Patient(
    fullName: String,
    identificationNumber: String,
    gender: Gender,
    email: String,
    val phone: String,
    var address: Address
) : Person(fullName, identificationNumber, gender, email)