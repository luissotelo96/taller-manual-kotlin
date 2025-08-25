// ============================================
// PILAR 2: FUNCIONES PURAS
// ============================================
// Funciones que siempre producen el mismo resultado para los mismos inputs
// No tienen efectos secundarios

// Ejemplo 1: Funciones matemáticas puras
fun ejemploFuncionesMatematicas() {
    println("=== EJEMPLO 1: FUNCIONES MATEMÁTICAS PURAS ===")
    
    // Función pura: siempre retorna el mismo resultado
    fun calcularAreaCirculo(radio: Double): Double {
        return Math.PI * radio * radio
    }
    
    // Función pura: calcula el factorial
    fun factorial(n: Int): Int {
        return if (n <= 1) 1 else n * factorial(n - 1)
    }
    
    // Función pura: determina si un número es primo
    fun esPrimo(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2 until n) {
            if (n % i == 0) return false
        }
        return true
    }
    
    println("Área círculo radio 5: ${calcularAreaCirculo(5.0)}")
    println("Área círculo radio 5: ${calcularAreaCirculo(5.0)}") // Mismo resultado
    println("Factorial de 5: ${factorial(5)}")
    println("¿Es 17 primo? ${esPrimo(17)}")
    println("¿Es 17 primo? ${esPrimo(17)}") // Mismo resultado
}

// Ejemplo 2: Funciones puras con strings y transformaciones
fun ejemploFuncionesString() {
    println("\n=== EJEMPLO 2: FUNCIONES PURAS CON STRINGS ===")
    
    // Función pura: formatea un nombre
    fun formatearNombre(nombre: String, apellido: String): String {
        return "${nombre.capitalize()} ${apellido.capitalize()}"
    }
    
    // Función pura: valida email
    fun validarEmail(email: String): Boolean {
        return email.contains("@") && email.contains(".")
    }
    
    // Función pura: cuenta vocales
    fun contarVocales(texto: String): Int {
        return texto.lowercase().count { it in "aeiouáéíóúü" }
    }
    
    // Función pura: genera saludo personalizado
    fun generarSaludo(nombre: String, hora: Int): String {
        val saludo = when {
            hora < 12 -> "Buenos días"
            hora < 18 -> "Buenas tardes"
            else -> "Buenas noches"
        }
        return "$saludo, $nombre"
    }
    
    println("Nombre formateado: ${formatearNombre("maría", "garcía")}")
    println("¿Email válido? ${validarEmail("usuario@dominio.com")}")
    println("Vocales en 'programación': ${contarVocales("programación")}")
    println("Saludo: ${generarSaludo("Ana", 14)}")
    println("Saludo: ${generarSaludo("Ana", 14)}") // Mismo resultado
}

// Ejemplo de función NO pura para comparación
var contador = 0

fun funcionNoPura(): Int {
    contador++ // Efecto secundario: modifica estado global
    return contador
}

fun mostrarDiferenciaFunciones() {
    println("\n=== COMPARACIÓN: FUNCIÓN PURA vs NO PURA ===")
    
    // Función pura
    fun funcionPura(x: Int): Int = x * 2
    
    println("Función pura (5): ${funcionPura(5)}")
    println("Función pura (5): ${funcionPura(5)}") // Siempre igual
    
    // Función no pura
    println("Función no pura: ${funcionNoPura()}")
    println("Función no pura: ${funcionNoPura()}") // Resultado diferente
}

fun main() {
    ejemploFuncionesMatematicas()
    ejemploFuncionesString()
    mostrarDiferenciaFunciones()
} 