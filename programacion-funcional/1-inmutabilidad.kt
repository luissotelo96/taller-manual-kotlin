// ============================================
// PILAR 1: INMUTABILIDAD
// ============================================
// Los datos no se modifican una vez creados

// Ejemplo 1: Listas inmutables vs mutables
fun ejemploInmutabilidadListas() {
    println("=== EJEMPLO 1: LISTAS INMUTABLES ===")
    
    // Lista inmutable - no se puede modificar
    val listaInmutable = listOf(1, 2, 3, 4, 5)
    println("Lista original: $listaInmutable")
    
    // Intentar modificar causaría error de compilación:
    // listaInmutable.add(6) // ❌ Error: no se puede modificar
    
    // En lugar de modificar, creamos una nueva lista
    val nuevaLista = listaInmutable + 6
    println("Nueva lista: $nuevaLista")
    println("Lista original sigue igual: $listaInmutable")
    
    // Lista mutable para comparación
    val listaMutable = mutableListOf(1, 2, 3, 4, 5)
    listaMutable.add(6) // ✅ Se puede modificar
    println("Lista mutable modificada: $listaMutable")
}

// Ejemplo 2: Clases de datos inmutables
data class Usuario(
    val id: Int,
    val nombre: String,
    val email: String,
    val edad: Int
)

fun ejemploInmutabilidadClases() {
    println("\n=== EJEMPLO 2: CLASES DE DATOS INMUTABLES ===")
    
    val usuario = Usuario(1, "Ana García", "ana@email.com", 25)
    println("Usuario original: $usuario")
    
    // No se puede modificar directamente:
    // usuario.nombre = "María" // ❌ Error: no se puede modificar
    
    // En lugar de modificar, creamos una nueva instancia
    val usuarioActualizado = usuario.copy(
        nombre = "María García",
        edad = 26
    )
    println("Usuario actualizado: $usuarioActualizado")
    println("Usuario original sigue igual: $usuario")
    
    // También podemos usar copy() para crear variaciones
    val usuarioConNuevoEmail = usuario.copy(email = "ana.nueva@email.com")
    println("Usuario con nuevo email: $usuarioConNuevoEmail")
}

fun main() {
    ejemploInmutabilidadListas()
    ejemploInmutabilidadClases()
} 