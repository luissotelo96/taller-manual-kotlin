package repositories

import entities.Doctor
import interfaces.CrudRepository

class DoctorRepository : CrudRepository<Doctor, String> {
    private val storage = mutableMapOf<String, Doctor>()

    override fun create(entity: Doctor): Doctor {
        require(!storage.containsKey(entity.licenseNumber)) { "Duplicate licenseNumber" }
        storage[entity.licenseNumber] = entity
        return entity
    }

    override fun readById(id: String): Doctor? = storage[id]

    override fun update(entity: Doctor): Doctor {
        require(storage.containsKey(entity.licenseNumber)) { "Doctor not found" }
        storage[entity.licenseNumber] = entity
        return entity
    }

    override fun deleteById(id: String) {
        storage.remove(id)
    }

    override fun listAll(): List<Doctor> = storage.values.toList()
}