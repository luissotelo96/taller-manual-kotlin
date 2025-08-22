package entities

import enum.Gender

open class Person(
    val fullName: String,
    val identificationNumber: String,
    val gender: Gender,
    val email: String
)