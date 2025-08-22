package services

import entities.Doctor
import entities.Hospital
import enum.Gender

class HospitalService(private val hospital: Hospital) {
    fun totalSalaries(): Double =
        hospital.listDoctors().sumOf { it.salary }

    fun totalSalariesBySpecialty(): Map<String, Double> =
        hospital.listDoctors().groupBy { it.specialty }.mapValues { (_, v) -> v.sumOf { it.salary } }

    fun patientGenderPercentages(): Map<Gender, Double> {
        val patients = hospital.listPatients()
        if (patients.isEmpty()) return Gender.values().associateWith { 0.0 }
        val total = patients.size.toDouble()
        return Gender.values().associateWith { g ->
            val count = patients.count { it.gender == g }.toDouble()
            (count / total) * 100.0
        }
    }

    fun doctorCountBySpecialty(): Map<String, Int> =
        hospital.listDoctors().groupingBy { it.specialty }.eachCount()

    fun mostSeniorDoctor(): Doctor? =
        hospital.listDoctors().minByOrNull { it.joinYear }
}