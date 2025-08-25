// ============================================
// PILAR 5: EVALUACIÓN PEREZOSA (LAZY EVALUATION)
// ============================================
// Solo evaluar expresiones cuando son necesarias

// Ejemplo 1: Secuencias (Sequences) - Evaluación perezosa
fun ejemploSecuencias() {
    println("=== EJEMPLO 1: SECUENCIAS (EVALUACIÓN PEREZOSA) ===")
    
    // Lista normal (evaluación ansiosa)
    val listaNormal = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter { 
            println("Filtrando: $it")
            it % 2 == 0 
        }
        .map { 
            println("Mapeando: $it")
            it * 2 
        }
        .take(3)
    
    println("Lista normal procesada: $listaNormal")
    
    // Secuencia (evaluación perezosa)
    val secuencia = sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter { 
            println("Filtrando (lazy): $it")
            it % 2 == 0 
        }
        .map { 
            println("Mapeando (lazy): $it")
            it * 2 
        }
        .take(3)
    
    println("Secuencia creada (sin evaluar aún)")
    val resultadoSecuencia = secuencia.toList()
    println("Secuencia procesada: $resultadoSecuencia")
    
    // Generando secuencias infinitas
    fun generarNumerosInfinitos(): Sequence<Int> = sequence {
        var numero = 1
        while (true) {
            yield(numero++)
        }
    }
    
    val numerosInfinitos = generarNumerosInfinitos()
        .filter { it % 2 == 0 }
        .map { it * it }
        .take(5)
    
    println("Primeros 5 números pares al cuadrado: ${numerosInfinitos.toList()}")
    
    // Secuencia de Fibonacci perezosa
    fun fibonacci(): Sequence<Long> = sequence {
        var terms = Pair(0L, 1L)
        while (true) {
            yield(terms.first)
            terms = Pair(terms.second, terms.first + terms.second)
        }
    }
    
    val primerosFibonacci = fibonacci().take(10).toList()
    println("Primeros 10 números de Fibonacci: $primerosFibonacci")
}

// Ejemplo 2: Propiedades lazy y evaluación perezosa
fun ejemploPropiedadesLazy() {
    println("\n=== EJEMPLO 2: PROPIEDADES LAZY ===")
    
    class CalculadoraPerezosa {
        // Propiedad lazy - solo se calcula cuando se accede por primera vez
        val resultadoComplejo by lazy {
            println("Calculando resultado complejo...")
            Thread.sleep(1000) // Simular cálculo costoso
            (1..1000000).sum()
        }
        
        // Propiedad lazy con validación
        val configuracion by lazy {
            println("Cargando configuración...")
            mapOf(
                "maxUsuarios" to 1000,
                "timeout" to 30,
                "debug" to true
            )
        }
        
        // Propiedad lazy que depende de otra
        val maxConexiones by lazy {
            println("Calculando máximo de conexiones...")
            configuracion["maxUsuarios"]!! * 2
        }
    }
    
    val calculadora = CalculadoraPerezosa()
    println("Calculadora creada")
    
    // Solo ahora se ejecuta el cálculo
    println("Accediendo a resultado complejo...")
    println("Resultado: ${calculadora.resultadoComplejo}")
    
    // Se ejecuta solo una vez
    println("Accediendo nuevamente...")
    println("Resultado: ${calculadora.resultadoComplejo}")
    
    println("Accediendo a configuración...")
    println("Configuración: ${calculadora.configuracion}")
    println("Máximo conexiones: ${calculadora.maxConexiones}")
}

// Ejemplo 3: Evaluación perezosa con funciones
fun ejemploEvaluacionPerezosaFunciones() {
    println("\n=== EJEMPLO 3: EVALUACIÓN PEREZOSA CON FUNCIONES ===")
    
    // Función que simula un cálculo costoso
    fun calculoCostoso(nombre: String): String {
        println("Ejecutando cálculo costoso para: $nombre")
        Thread.sleep(500) // Simular procesamiento
        return "Resultado procesado para $nombre"
    }
    
    // Función que usa evaluación perezosa
    fun procesarUsuarios(usuarios: List<String>, procesar: Boolean) {
        println("Iniciando procesamiento...")
        
        // Solo se ejecuta si procesar es true
        val resultados = if (procesar) {
            usuarios.map { calculoCostoso(it) }
        } else {
            emptyList()
        }
        
        println("Procesamiento completado")
        if (procesar) {
            println("Resultados: $resultados")
        }
    }
    
    val usuarios = listOf("Ana", "Bob", "Carlos", "Diana")
    
    println("Caso 1: Sin procesar")
    procesarUsuarios(usuarios, false)
    
    println("\nCaso 2: Con procesamiento")
    procesarUsuarios(usuarios, true)
    
    // Evaluación perezosa con secuencias
    fun generarSecuenciaPerezosa(inicio: Int): Sequence<Int> = sequence {
        var actual = inicio
        while (true) {
            yield(actual)
            actual += 2
        }
    }
    
    val secuenciaPares = generarSecuenciaPerezosa(2)
        .filter { 
            println("Verificando si $it es múltiplo de 6")
            it % 6 == 0 
        }
        .take(3)
    
    println("\nGenerando secuencia perezosa...")
    val resultado = secuenciaPares.toList()
    println("Primeros 3 múltiplos de 6: $resultado")
    
    // Evaluación perezosa con when
    fun evaluarCondicionPerezosa(condicion: String, valor: Int): String {
        return when (condicion) {
            "positivo" -> if (valor > 0) "Es positivo" else "No es positivo"
            "par" -> if (valor % 2 == 0) "Es par" else "No es par"
            "primo" -> {
                val esPrimo = (2 until valor).none { valor % it == 0 }
                if (esPrimo) "Es primo" else "No es primo"
            }
            else -> "Condición no reconocida"
        }
    }
    
    println("\nEvaluación condicional perezosa:")
    println("Valor 7, condición 'positivo': ${evaluarCondicionPerezosa("positivo", 7)}")
    println("Valor 7, condición 'par': ${evaluarCondicionPerezosa("par", 7)}")
    println("Valor 7, condición 'primo': ${evaluarCondicionPerezosa("primo", 7)}")
}

fun main() {
    ejemploSecuencias()
    ejemploPropiedadesLazy()
    ejemploEvaluacionPerezosaFunciones()
} 