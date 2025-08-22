package entities

import enum.Gender

class Doctor(
    fullName: String,
    identificationNumber: String,
    gender: Gender,
    email: String,
    val licenseNumber: String,
    var specialty: String,
    val joinYear: Int,
    var salary: Double,
    val assignedPatientIds: MutableSet<String> = mutableSetOf()
) : Person(fullName, identificationNumber, gender, email)