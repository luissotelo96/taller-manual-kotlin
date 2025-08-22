package repositories

import entities.Patient
import interfaces.CrudRepository

class PatientRepository : CrudRepository<Patient, String> {
    private val storage = mutableMapOf<String, Patient>()

    override fun create(entity: Patient): Patient {
        require(!storage.containsKey(entity.identificationNumber)) { "Duplicate patient idNumber" }
        storage[entity.identificationNumber] = entity
        return entity
    }

    override fun readById(id: String): Patient? = storage[id]

    override fun update(entity: Patient): Patient {
        require(storage.containsKey(entity.identificationNumber)) { "Patient not found" }
        storage[entity.identificationNumber] = entity
        return entity
    }

    override fun deleteById(id: String) {
        storage.remove(id)
    }

    override fun listAll(): List<Patient> = storage.values.toList()
}