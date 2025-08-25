// ============================================
// PILAR 4: COMPOSICIÓN DE FUNCIONES
// ============================================
// Combinar funciones para crear nuevas funcionalidades

// Ejemplo 1: Composición básica de funciones
fun ejemploComposicionBasica() {
    println("=== EJEMPLO 1: COMPOSICIÓN BÁSICA ===")
    
    // Funciones individuales
    fun duplicar(x: Int): Int = x * 2
    fun sumarUno(x: Int): Int = x + 1
    fun elevarAlCuadrado(x: Int): Int = x * x
    
    // Composición manual
    fun duplicarYSumarUno(x: Int): Int = sumarUno(duplicar(x))
    fun duplicarSumarUnoYElevar(x: Int): Int = elevarAlCuadrado(sumarUno(duplicar(x)))
    
    val numero = 5
    println("Número original: $numero")
    println("Duplicado: ${duplicar(numero)}")
    println("Sumar uno: ${sumarUno(numero)}")
    println("Elevar al cuadrado: ${elevarAlCuadrado(numero)}")
    println("Duplicar y sumar uno: ${duplicarYSumarUno(numero)}")
    println("Duplicar, sumar uno y elevar: ${duplicarSumarUnoYElevar(numero)}")
    
    // Composición usando infix function
    infix fun <A, B, C> ((A) -> B).compose(g: (B) -> C): (A) -> C {
        return { a -> g(this(a)) }
    }
    
    // Crear composiciones usando el operador infix
    val duplicarYSumar = duplicar compose sumarUno
    val duplicarSumarYElevar = duplicar compose sumarUno compose elevarAlCuadrado
    val elevarYDuplicar = elevarAlCuadrado compose duplicar
    
    println("Composición (duplicar + sumar): ${duplicarYSumar(numero)}")
    println("Composición (duplicar + sumar + elevar): ${duplicarSumarYElevar(numero)}")
    println("Composición (elevar + duplicar): ${elevarYDuplicar(numero)}")
}

// Ejemplo 2: Composición con funciones de strings
fun ejemploComposicionStrings() {
    println("\n=== EJEMPLO 2: COMPOSICIÓN CON STRINGS ===")
    
    // Funciones de transformación de strings
    fun limpiarEspacios(texto: String): String = texto.trim()
    fun convertirMayusculas(texto: String): String = texto.uppercase()
    fun agregarExclamacion(texto: String): String = "$texto!"
    fun agregarPrefijo(prefijo: String): (String) -> String = { texto -> "$prefijo$texto" }
    fun agregarSufijo(sufijo: String): (String) -> String = { texto -> "$texto$sufijo" }
    fun capitalizar(texto: String): String = texto.replaceFirstChar { it.uppercase() }
    
    // Composición manual
    fun procesarTexto(texto: String): String {
        return agregarExclamacion(
            convertirMayusculas(
                limpiarEspacios(texto)
            )
        )
    }
    
    // Composición usando infix function
    infix fun <A, B, C> ((A) -> B).compose(g: (B) -> C): (A) -> C {
        return { a -> g(this(a)) }
    }
    
    // Crear composiciones
    val limpiarYMayusculas = limpiarEspacios compose convertirMayusculas
    val procesarCompleto = limpiarEspacios compose convertirMayusculas compose agregarExclamacion
    val procesarConPrefijo = limpiarEspacios compose capitalizar compose agregarPrefijo("Sr. ")
    val procesarConSufijo = limpiarEspacios compose capitalizar compose agregarSufijo(" - Usuario")
    
    val textoSucio = "  hola mundo  "
    println("Texto original: '$textoSucio'")
    println("Limpiar y mayúsculas: '${limpiarYMayusculas(textoSucio)}'")
    println("Procesar completo: '${procesarCompleto(textoSucio)}'")
    println("Con prefijo: '${procesarConPrefijo(textoSucio)}'")
    println("Con sufijo: '${procesarConSufijo(textoSucio)}'")
    
    // Composición con validación
    fun validarLongitud(minLongitud: Int): (String) -> String {
        return { texto ->
            if (texto.length >= minLongitud) texto
            else throw IllegalArgumentException("Texto muy corto")
        }
    }
    
    val procesarYValidar = limpiarEspacios compose capitalizar compose validarLongitud(3)
    
    try {
        println("Procesar y validar (corto): '${procesarYValidar("ab")}'")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    
    println("Procesar y validar (largo): '${procesarYValidar("hola")}'")
}

// Ejemplo 3: Composición con funciones de orden superior
fun ejemploComposicionAvanzada() {
    println("\n=== EJEMPLO 3: COMPOSICIÓN AVANZADA ===")
    
    // Funciones de transformación de listas
    fun filtrarPares(lista: List<Int>): List<Int> = lista.filter { it % 2 == 0 }
    fun duplicarElementos(lista: List<Int>): List<Int> = lista.map { it * 2 }
    fun sumarElementos(lista: List<Int>): Int = lista.sum()
    fun ordenarAscendente(lista: List<Int>): List<Int> = lista.sorted()
    fun tomarPrimeros(n: Int): (List<Int>) -> List<Int> = { lista -> lista.take(n) }
    
    // Composición de funciones de listas
    infix fun <A, B, C> ((A) -> B).compose(g: (B) -> C): (A) -> C {
        return { a -> g(this(a)) }
    }
    
    val numeros = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // Crear pipeline de procesamiento
    val pipeline1 = filtrarPares compose duplicarElementos compose sumarElementos
    val pipeline2 = ordenarAscendente compose tomarPrimeros(5) compose duplicarElementos
    val pipeline3 = filtrarPares compose ordenarAscendente compose tomarPrimeros(3)
    
    println("Lista original: $numeros")
    println("Pipeline 1 (pares → duplicar → sumar): ${pipeline1(numeros)}")
    println("Pipeline 2 (ordenar → primeros 5 → duplicar): ${pipeline2(numeros)}")
    println("Pipeline 3 (pares → ordenar → primeros 3): ${pipeline3(numeros)}")
    
    // Composición con funciones que retornan funciones
    fun crearFiltro(condicion: (Int) -> Boolean): (List<Int>) -> List<Int> {
        return { lista -> lista.filter(condicion) }
    }
    
    fun crearTransformacion(operacion: (Int) -> Int): (List<Int>) -> List<Int> {
        return { lista -> lista.map(operacion) }
    }
    
    val filtrarMayoresQue5 = crearFiltro { it > 5 }
    val multiplicarPor3 = crearTransformacion { it * 3 }
    val elevarAlCuadrado = crearTransformacion { it * it }
    
    val pipeline4 = filtrarMayoresQue5 compose multiplicarPor3 compose sumarElementos
    val pipeline5 = filtrarPares compose elevarAlCuadrado compose tomarPrimeros(3)
    
    println("Pipeline 4 (>5 → ×3 → sumar): ${pipeline4(numeros)}")
    println("Pipeline 5 (pares → ² → primeros 3): ${pipeline5(numeros)}")
}

fun main() {
    ejemploComposicionBasica()
    ejemploComposicionStrings()
    ejemploComposicionAvanzada()
} 