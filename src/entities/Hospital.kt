package entities

import repositories.DoctorRepository
import repositories.PatientRepository

class Hospital(
    val name: String,
    val nit: String,
    val address: Address,
    var hasInpatients: Boolean,
    val doctorRepo: DoctorRepository = DoctorRepository(),
    val patientRepo: PatientRepository = PatientRepository()
) {
    fun addDoctor(doctor: Doctor): Doctor = doctorRepo.create(doctor)
    fun getDoctorByLicense(licenseNumber: String): Doctor? = doctorRepo.readById(licenseNumber)
    fun updateDoctor(doctor: Doctor): Doctor = doctorRepo.update(doctor)
    fun deleteDoctorByLicense(licenseNumber: String) {
        val total = doctorRepo.listAll().size
        require(total > 1) { "Hospital must keep at least one active doctor" }
        doctorRepo.deleteById(licenseNumber)
    }
    fun listDoctors(): List<Doctor> = doctorRepo.listAll()

    fun addPatient(patient: Patient): Patient = patientRepo.create(patient)
    fun getPatientById(idNumber: String): Patient? = patientRepo.readById(idNumber)
    fun updatePatient(patient: Patient): Patient = patientRepo.update(patient)
    fun deletePatientById(idNumber: String) = patientRepo.deleteById(idNumber)
    fun listPatients(): List<Patient> = patientRepo.listAll()

    fun assignPatientToDoctor(patientId: String, doctorLicense: String) {
        val patient = getPatientById(patientId) ?: error("Patient not found")
        val doctor = getDoctorByLicense(doctorLicense) ?: error("Doctor not found")
        doctor.assignedPatientIds.add(patient.identificationNumber)
        updateDoctor(doctor)
    }

    fun unassignPatientFromDoctor(patientId: String, doctorLicense: String) {
        val doctor = getDoctorByLicense(doctorLicense) ?: error("Doctor not found")
        doctor.assignedPatientIds.remove(patientId)
        updateDoctor(doctor)
    }
}