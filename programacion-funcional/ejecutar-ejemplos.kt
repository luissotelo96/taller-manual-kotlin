// ============================================
// SCRIPT PARA EJECUTAR TODOS LOS EJEMPLOS
// ============================================
// Este archivo ejecuta todos los ejemplos de programación funcional

fun main() {
    println("🚀 EJECUTANDO TODOS LOS EJEMPLOS DE PROGRAMACIÓN FUNCIONAL")
    println("=" * 60)
    
    // Ejecutar ejemplos de pilares de programación funcional
    println("\n📚 PILARES DE LA PROGRAMACIÓN FUNCIONAL")
    println("-" * 40)
    
    println("\n1️⃣ INMUTABILIDAD")
    println("=" * 20)
    ejecutarInmutabilidad()
    
    println("\n2️⃣ FUNCIONES PURAS")
    println("=" * 20)
    ejecutarFuncionesPuras()
    
    println("\n3️⃣ FUNCIONES DE ORDEN SUPERIOR")
    println("=" * 20)
    ejecutarFuncionesOrdenSuperior()
    
    println("\n4️⃣ COMPOSICIÓN DE FUNCIONES")
    println("=" * 20)
    ejecutarComposicionFunciones()
    
    println("\n5️⃣ EVALUACIÓN PEREZOSA")
    println("=" * 20)
    ejecutarEvaluacionPerezosa()
    
    // Ejecutar ejemplo de funciones de ámbito
    println("\n🔧 FUNCIONES DE ÁMBITO")
    println("-" * 40)
    
    println("\n6️⃣ FUNCIONES DE ÁMBITO (SISTEMA DE GESTIÓN DE USUARIOS)")
    println("=" * 20)
    ejecutarFuncionesAmbito()
    
    println("\n✅ TODOS LOS EJEMPLOS EJECUTADOS EXITOSAMENTE")
    println("=" * 60)
}

// Función auxiliar para repetir strings
operator fun String.times(n: Int): String = this.repeat(n)

// Funciones que ejecutan cada ejemplo
fun ejecutarInmutabilidad() {
    // Ejemplo 1: Listas inmutables vs mutables
    println("=== EJEMPLO 1: LISTAS INMUTABLES ===")
    
    val listaInmutable = listOf(1, 2, 3, 4, 5)
    println("Lista original: $listaInmutable")
    
    val nuevaLista = listaInmutable + 6
    println("Nueva lista: $nuevaLista")
    println("Lista original sigue igual: $listaInmutable")
    
    val listaMutable = mutableListOf(1, 2, 3, 4, 5)
    listaMutable.add(6)
    println("Lista mutable modificada: $listaMutable")
    
    // Ejemplo 2: Clases de datos inmutables
    println("\n=== EJEMPLO 2: CLASES DE DATOS INMUTABLES ===")
    
    data class Usuario(val id: Int, val nombre: String, val email: String, val edad: Int)
    
    val usuario = Usuario(1, "Ana García", "ana@email.com", 25)
    println("Usuario original: $usuario")
    
    val usuarioActualizado = usuario.copy(nombre = "María García", edad = 26)
    println("Usuario actualizado: $usuarioActualizado")
    println("Usuario original sigue igual: $usuario")
}

fun ejecutarFuncionesPuras() {
    // Ejemplo 1: Funciones matemáticas puras
    println("=== EJEMPLO 1: FUNCIONES MATEMÁTICAS PURAS ===")
    
    fun calcularAreaCirculo(radio: Double): Double = Math.PI * radio * radio
    fun factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n - 1)
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
    
    // Ejemplo 2: Funciones puras con strings
    println("\n=== EJEMPLO 2: FUNCIONES PURAS CON STRINGS ===")
    
    fun formatearNombre(nombre: String, apellido: String): String = 
        "${nombre.capitalize()} ${apellido.capitalize()}"
    fun validarEmail(email: String): Boolean = email.contains("@") && email.contains(".")
    fun contarVocales(texto: String): Int = 
        texto.lowercase().count { it in "aeiouáéíóúü" }
    
    println("Nombre formateado: ${formatearNombre("maría", "garcía")}")
    println("¿Email válido? ${validarEmail("usuario@dominio.com")}")
    println("Vocales en 'programación': ${contarVocales("programación")}")
}

fun ejecutarFuncionesOrdenSuperior() {
    // Ejemplo 1: Funciones que toman funciones como parámetros
    println("=== EJEMPLO 1: FUNCIONES COMO PARÁMETROS ===")
    
    fun aplicarOperacion(lista: List<Int>, operacion: (Int) -> Int): List<Int> = 
        lista.map(operacion)
    fun filtrarElementos(lista: List<Int>, predicado: (Int) -> Boolean): List<Int> = 
        lista.filter(predicado)
    
    val numeros = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    val duplicados = aplicarOperacion(numeros) { it * 2 }
    val cuadrados = aplicarOperacion(numeros) { it * it }
    val pares = filtrarElementos(numeros) { it % 2 == 0 }
    
    println("Números originales: $numeros")
    println("Duplicados: $duplicados")
    println("Cuadrados: $cuadrados")
    println("Pares: $pares")
    
    // Ejemplo 2: Funciones que retornan funciones
    println("\n=== EJEMPLO 2: FUNCIONES QUE RETORNAN FUNCIONES ===")
    
    fun crearMultiplicador(factor: Int): (Int) -> Int = { numero -> numero * factor }
    fun crearValidador(tipo: String): (String) -> Boolean = when (tipo) {
        "email" -> { texto -> texto.contains("@") && texto.contains(".") }
        "telefono" -> { texto -> texto.length >= 7 && texto.all { it.isDigit() } }
        else -> { _ -> false }
    }
    
    val duplicar = crearMultiplicador(2)
    val triplicar = crearMultiplicador(3)
    val validarEmail = crearValidador("email")
    val validarTelefono = crearValidador("telefono")
    
    println("Duplicar 5: ${duplicar(5)}")
    println("Triplicar 5: ${triplicar(5)}")
    println("¿'usuario@email.com' es email válido? ${validarEmail("usuario@email.com")}")
    println("¿'3001234567' es teléfono válido? ${validarTelefono("3001234567")}")
}

fun ejecutarComposicionFunciones() {
    // Ejemplo 1: Composición básica
    println("=== EJEMPLO 1: COMPOSICIÓN BÁSICA ===")
    
    fun duplicar(x: Int): Int = x * 2
    fun sumarUno(x: Int): Int = x + 1
    fun elevarAlCuadrado(x: Int): Int = x * x
    
    infix fun <A, B, C> ((A) -> B).compose(g: (B) -> C): (A) -> C = { a -> g(this(a)) }
    
    val duplicarYSumar = duplicar compose sumarUno
    val duplicarSumarYElevar = duplicar compose sumarUno compose elevarAlCuadrado
    
    val numero = 5
    println("Número original: $numero")
    println("Composición (duplicar + sumar): ${duplicarYSumar(numero)}")
    println("Composición (duplicar + sumar + elevar): ${duplicarSumarYElevar(numero)}")
    
    // Ejemplo 2: Composición con strings
    println("\n=== EJEMPLO 2: COMPOSICIÓN CON STRINGS ===")
    
    fun limpiarEspacios(texto: String): String = texto.trim()
    fun convertirMayusculas(texto: String): String = texto.uppercase()
    fun agregarExclamacion(texto: String): String = "$texto!"
    
    val limpiarYMayusculas = limpiarEspacios compose convertirMayusculas
    val procesarCompleto = limpiarEspacios compose convertirMayusculas compose agregarExclamacion
    
    val textoSucio = "  hola mundo  "
    println("Texto original: '$textoSucio'")
    println("Limpiar y mayúsculas: '${limpiarYMayusculas(textoSucio)}'")
    println("Procesar completo: '${procesarCompleto(textoSucio)}'")
}

fun ejecutarEvaluacionPerezosa() {
    // Ejemplo 1: Secuencias vs listas
    println("=== EJEMPLO 1: SECUENCIAS (EVALUACIÓN PEREZOSA) ===")
    
    val listaNormal = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .take(3)
    
    val secuencia = sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .take(3)
    
    println("Lista normal procesada: $listaNormal")
    println("Secuencia procesada: ${secuencia.toList()}")
    
    // Ejemplo 2: Propiedades lazy
    println("\n=== EJEMPLO 2: PROPIEDADES LAZY ===")
    
    class CalculadoraPerezosa {
        val resultadoComplejo by lazy {
            println("Calculando resultado complejo...")
            (1..1000).sum()
        }
        
        val configuracion by lazy {
            println("Cargando configuración...")
            mapOf("maxUsuarios" to 1000, "timeout" to 30)
        }
    }
    
    val calculadora = CalculadoraPerezosa()
    println("Calculadora creada")
    println("Accediendo a resultado complejo: ${calculadora.resultadoComplejo}")
    println("Accediendo a configuración: ${calculadora.configuracion}")
}

fun ejecutarFuncionesAmbito() {
    // Sistema de gestión de usuarios simplificado
    println("=== SISTEMA DE GESTIÓN DE USUARIOS ===")
    println("Demostración de funciones de ámbito en Kotlin\n")
    
    data class Usuario(
        var id: Int = 0,
        var nombre: String = "",
        var email: String = "",
        var activo: Boolean = true
    )
    
    class GestorUsuarios {
        private val usuarios = mutableListOf<Usuario>()
        
        // APPLY: Crear y configurar usuario
        fun crearUsuarioConApply(datos: Map<String, Any>): Usuario {
            return Usuario().apply {
                id = datos["id"] as? Int ?: (usuarios.size + 1)
                nombre = datos["nombre"] as? String ?: ""
                email = datos["email"] as? String ?: ""
                activo = datos["activo"] as? Boolean ?: true
            }
        }
        
        // LET: Procesar usuario solo si existe
        fun procesarUsuarioConLet(usuarioId: Int): String {
            return buscarUsuario(usuarioId)?.let { usuario ->
                "Usuario: ${usuario.nombre.uppercase()}, Email: ${usuario.email}"
            } ?: "Usuario no encontrado"
        }
        
        // ALSO: Registrar usuario y realizar acciones adicionales
        fun registrarUsuarioConAlso(usuario: Usuario): Usuario {
            return usuario.also { u ->
                println("Registrando usuario: ${u.nombre}")
                usuarios.add(u)
                println("Usuario ${u.nombre} registrado exitosamente")
            }
        }
        
        // WITH: Configurar sistema
        fun configurarSistemaConWith(): Map<String, Int> {
            return with(mutableMapOf<String, Int>()) {
                put("maxUsuarios", 2000)
                put("timeoutSesion", 60)
                put("usuariosRegistrados", usuarios.size)
                this
            }
        }
        
        // RUN: Inicializar sistema
        fun inicializarSistemaConRun(): String {
            return run {
                println("Inicializando sistema de gestión de usuarios...")
                
                val admin = Usuario().apply {
                    id = 1
                    nombre = "Administrador"
                    email = "admin@sistema.com"
                }
                
                registrarUsuarioConAlso(admin)
                
                "Sistema inicializado con ${usuarios.size} usuarios"
            }
        }
        
        private fun buscarUsuario(id: Int): Usuario? = usuarios.find { it.id == id }
        fun listarUsuarios(): List<Usuario> = usuarios.toList()
    }
    
    val gestor = GestorUsuarios()
    
    // 1. Inicializar sistema con RUN
    println("1. Inicializando sistema...")
    val resultadoInicializacion = gestor.inicializarSistemaConRun()
    println("Resultado: $resultadoInicializacion\n")
    
    // 2. Crear usuarios con APPLY
    println("2. Creando usuarios...")
    val datosUsuario = mapOf(
        "nombre" to "Ana García",
        "email" to "ana.garcia@email.com"
    )
    
    val usuario = gestor.crearUsuarioConApply(datosUsuario)
    println("Usuario creado: $usuario\n")
    
    // 3. Registrar usuario con ALSO
    println("3. Registrando usuario...")
    gestor.registrarUsuarioConAlso(usuario)
    println()
    
    // 4. Procesar información con LET
    println("4. Procesando información...")
    val infoUsuario = gestor.procesarUsuarioConLet(usuario.id)
    val infoUsuarioInexistente = gestor.procesarUsuarioConLet(999)
    
    println("Info usuario: $infoUsuario")
    println("Info usuario inexistente: $infoUsuarioInexistente\n")
    
    // 5. Configurar sistema con WITH
    println("5. Configurando sistema...")
    val configuracion = gestor.configurarSistemaConWith()
    println("Configuración: $configuracion\n")
    
    // 6. Mostrar estado final
    println("6. Estado final del sistema:")
    println("Usuarios registrados: ${gestor.listarUsuarios().size}")
    gestor.listarUsuarios().forEach { usuario ->
        println("  - ${usuario.nombre} (ID: ${usuario.id})")
    }
    
    println("\n=== DEMOSTRACIÓN COMPLETADA ===")
} 