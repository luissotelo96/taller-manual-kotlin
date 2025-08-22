package interfaces

interface CrudRepository<T, ID> {
    fun create(entity: T): T
    fun readById(id: ID): T?
    fun update(entity: T): T
    fun deleteById(id: ID)
    fun listAll(): List<T>
}