// ============================================
// PILAR 3: FUNCIONES DE ORDEN SUPERIOR
// ============================================
// Funciones que toman otras funciones como parámetros o retornan funciones

// Ejemplo 1: Funciones que toman funciones como parámetros
fun ejemploFuncionesComoParametros() {
    println("=== EJEMPLO 1: FUNCIONES COMO PARÁMETROS ===")
    
    // Función de orden superior que aplica una operación a cada elemento
    fun aplicarOperacion(lista: List<Int>, operacion: (Int) -> Int): List<Int> {
        return lista.map(operacion)
    }
    
    // Función de orden superior que filtra elementos
    fun filtrarElementos(lista: List<Int>, predicado: (Int) -> Boolean): List<Int> {
        return lista.filter(predicado)
    }
    
    // Función de orden superior que reduce una lista
    fun reducirLista(lista: List<Int>, operacion: (Int, Int) -> Int, valorInicial: Int): Int {
        return lista.fold(valorInicial, operacion)
    }
    
    val numeros = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // Aplicar diferentes operaciones
    val duplicados = aplicarOperacion(numeros) { it * 2 }
    val cuadrados = aplicarOperacion(numeros) { it * it }
    val incrementados = aplicarOperacion(numeros) { it + 1 }
    
    println("Números originales: $numeros")
    println("Duplicados: $duplicados")
    println("Cuadrados: $cuadrados")
    println("Incrementados: $incrementados")
    
    // Filtrar elementos
    val pares = filtrarElementos(numeros) { it % 2 == 0 }
    val mayoresQue5 = filtrarElementos(numeros) { it > 5 }
    val primos = filtrarElementos(numeros) { esPrimo(it) }
    
    println("Pares: $pares")
    println("Mayores que 5: $mayoresQue5")
    println("Primos: $primos")
    
    // Reducir lista
    val suma = reducirLista(numeros, { acc, num -> acc + num }, 0)
    val producto = reducirLista(numeros, { acc, num -> acc * num }, 1)
    val maximo = reducirLista(numeros, { acc, num -> if (num > acc) num else acc }, 0)
    
    println("Suma: $suma")
    println("Producto: $producto")
    println("Máximo: $maximo")
}

// Función auxiliar para verificar si un número es primo
fun esPrimo(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}

// Ejemplo 2: Funciones que retornan funciones
fun ejemploFuncionesQueRetornanFunciones() {
    println("\n=== EJEMPLO 2: FUNCIONES QUE RETORNAN FUNCIONES ===")
    
    // Función que retorna una función de multiplicación
    fun crearMultiplicador(factor: Int): (Int) -> Int {
        return { numero -> numero * factor }
    }
    
    // Función que retorna una función de comparación
    fun crearComparador(criterio: String): (Int, Int) -> Boolean {
        return when (criterio) {
            "ascendente" -> { a, b -> a < b }
            "descendente" -> { a, b -> a > b }
            else -> { a, b -> a == b }
        }
    }
    
    // Función que retorna una función de validación
    fun crearValidador(tipo: String): (String) -> Boolean {
        return when (tipo) {
            "email" -> { texto -> texto.contains("@") && texto.contains(".") }
            "telefono" -> { texto -> texto.length >= 7 && texto.all { it.isDigit() } }
            "nombre" -> { texto -> texto.length >= 2 && texto.all { it.isLetter() || it == ' ' } }
            else -> { _ -> false }
        }
    }
    
    // Usar las funciones que retornan funciones
    val duplicar = crearMultiplicador(2)
    val triplicar = crearMultiplicador(3)
    val multiplicarPor10 = crearMultiplicador(10)
    
    println("Duplicar 5: ${duplicar(5)}")
    println("Triplicar 5: ${triplicar(5)}")
    println("5 × 10: ${multiplicarPor10(5)}")
    
    val compararAscendente = crearComparador("ascendente")
    val compararDescendente = crearComparador("descendente")
    
    println("5 < 10: ${compararAscendente(5, 10)}")
    println("10 < 5: ${compararAscendente(10, 5)}")
    println("10 > 5: ${compararDescendente(10, 5)}")
    
    val validarEmail = crearValidador("email")
    val validarTelefono = crearValidador("telefono")
    val validarNombre = crearValidador("nombre")
    
    println("¿'usuario@email.com' es email válido? ${validarEmail("usuario@email.com")}")
    println("¿'3001234567' es teléfono válido? ${validarTelefono("3001234567")}")
    println("¿'Juan Pérez' es nombre válido? ${validarNombre("Juan Pérez")}")
}

// Ejemplo 3: Combinando ambos conceptos
fun ejemploCombinado() {
    println("\n=== EJEMPLO 3: COMBINANDO CONCEPTOS ===")
    
    // Función de orden superior que toma una función y retorna otra función
    fun crearTransformador(operacion: (Int) -> Int): (List<Int>) -> List<Int> {
        return { lista -> lista.map(operacion) }
    }
    
    // Función de orden superior que toma una función y retorna una función de validación
    fun crearValidadorPersonalizado(condicion: (String) -> Boolean): (List<String>) -> List<String> {
        return { lista -> lista.filter(condicion) }
    }
    
    val numeros = listOf(1, 2, 3, 4, 5)
    val textos = listOf("hola", "mundo", "kotlin", "funcional", "programacion")
    
    // Crear transformadores específicos
    val transformarCuadrados = crearTransformador { it * it }
    val transformarIncrementos = crearTransformador { it + 10 }
    
    // Crear validadores específicos
    val validarPalabrasLargas = crearValidadorPersonalizado { it.length > 4 }
    val validarPalabrasConA = crearValidadorPersonalizado { it.contains("a") }
    
    println("Números originales: $numeros")
    println("Cuadrados: ${transformarCuadrados(numeros)}")
    println("Incrementados en 10: ${transformarIncrementos(numeros)}")
    
    println("Textos originales: $textos")
    println("Palabras largas: ${validarPalabrasLargas(textos)}")
    println("Palabras con 'a': ${validarPalabrasConA(textos)}")
}

fun main() {
    ejemploFuncionesComoParametros()
    ejemploFuncionesQueRetornanFunciones()
    ejemploCombinado()
} 