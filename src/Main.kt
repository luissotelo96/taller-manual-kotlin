import entities.*
import enum.Gender
import services.HospitalService

fun main() {
    val hospitalAddress = Address(
        street = "Main Ave",
        number = "123",
        neighborhood = "Central",
        city = "Bogota",
        postalCode = "110111"
    )

    val hospital = Hospital(
        name = "City Hospital",
        nit = "900123456-7",
        address = hospitalAddress,
        hasInpatients = false
    )

    val d1 = Doctor(
        fullName = "Alice Carter",
        identificationNumber = "D-1001",
        gender = Gender.FEMALE,
        email = "alice.carter@hospital.com",
        licenseNumber = "LIC-001",
        specialty = "Cardiology",
        joinYear = 2010,
        salary = 120000.0
    )

    val d2 = Doctor(
        fullName = "Bob Nguyen",
        identificationNumber = "D-1002",
        gender = Gender.MALE,
        email = "bob.nguyen@hospital.com",
        licenseNumber = "LIC-002",
        specialty = "Neurology",
        joinYear = 2005,
        salary = 135000.0
    )
    val d3 = Doctor(
        fullName = "Evelyn Santos",
        identificationNumber = "D-1003",
        gender = Gender.FEMALE,
        email = "evelyn.santos@hospital.com",
        licenseNumber = "LIC-003",
        specialty = "Cardiology",
        joinYear = 2018,
        salary = 98000.0
    )

    hospital.addDoctor(d1)
    hospital.addDoctor(d2)
    hospital.addDoctor(d3)

    val readDoctor = hospital.getDoctorByLicense("LIC-003")
    println("Read doctor: ${readDoctor?.fullName} - ${readDoctor?.specialty}")

    val updatedD3 = Doctor(
        fullName = d3.fullName,
        identificationNumber = d3.identificationNumber,
        gender = d3.gender,
        email = d3.email,
        licenseNumber = d3.licenseNumber,
        specialty = "Pediatrics",
        joinYear = d3.joinYear,
        salary = 102000.0,
        assignedPatientIds = d3.assignedPatientIds
    )
    hospital.updateDoctor(updatedD3)
    println("Updated doctor LIC-003 specialty to ${hospital.getDoctorByLicense("LIC-003")?.specialty}")

    hospital.deleteDoctorByLicense("LIC-001")
    println("Doctors after delete: ${hospital.listDoctors().map { it.licenseNumber }}")

    val p1 = Patient(
        fullName = "Carlos Perez",
        identificationNumber = "P-2001",
        gender = Gender.MALE,
        email = "carlos.perez@mail.com",
        phone = "3001112233",
        address = Address("7th St", "45A", "Chapinero", "Bogota", "110231")
    )
    val p2 = Patient(
        fullName = "Maria Gomez",
        identificationNumber = "P-2002",
        gender = Gender.FEMALE,
        email = "maria.gomez@mail.com",
        phone = "3002223344",
        address = Address("8th St", "10-22", "Usaquen", "Bogota", "110221")
    )
    val p3 = Patient(
        fullName = "Alex Lee",
        identificationNumber = "P-2003",
        gender = Gender.OTHER,
        email = "alex.lee@mail.com",
        phone = "3003334455",
        address = Address("9th St", "99", "Suba", "Bogota", "110311")
    )

    hospital.addPatient(p1)
    hospital.addPatient(p2)
    hospital.addPatient(p3)

    val readPatient = hospital.getPatientById("P-2002")
    println("Read patient: ${readPatient?.fullName} - ${readPatient?.phone}")

    val updatedP2 = Patient(
        fullName = p2.fullName,
        identificationNumber = p2.identificationNumber,
        gender = p2.gender,
        email = p2.email,
        phone = "3009990000",
        address = p2.address.copy(number = "10-50")
    )
    hospital.updatePatient(updatedP2)
    println("Updated patient P-2002 phone: ${hospital.getPatientById("P-2002")?.phone}")

    hospital.deletePatientById("P-2003")
    println("Patients after delete: ${hospital.listPatients().map { it.identificationNumber }}")

    hospital.assignPatientToDoctor("P-2001", "LIC-002")
    hospital.assignPatientToDoctor("P-2002", "LIC-003")
    println("Doctor LIC-002 patients: ${hospital.getDoctorByLicense("LIC-002")?.assignedPatientIds}")
    println("Doctor LIC-003 patients: ${hospital.getDoctorByLicense("LIC-003")?.assignedPatientIds}")

    val service = HospitalService(hospital)

    val totalSalaries = service.totalSalaries()
    println("Total salaries: $totalSalaries")

    val totalBySpecialty = service.totalSalariesBySpecialty()
    println("Total salaries by specialty: $totalBySpecialty")

    val genderPercentages = service.patientGenderPercentages()
    println("Patient gender percentages: $genderPercentages")

    val doctorCountBySpec = service.doctorCountBySpecialty()
    println("Doctor count by specialty: $doctorCountBySpec")

    val mostSenior = service.mostSeniorDoctor()
    println("Most senior doctor: ${mostSenior?.fullName} - ${mostSenior?.specialty} (joinYear=${mostSenior?.joinYear})")
}