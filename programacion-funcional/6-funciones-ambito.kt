// ============================================
// FUNCIONES DE ÁMBITO EN KOTLIN
// ============================================
// apply, let, also, with, run

// Modelos de datos para la aplicación de gestión de usuarios
data class Usuario(
    var id: Int = 0,
    var nombre: String = "",
    var email: String = "",
    var telefono: String = "",
    var activo: Boolean = true,
    var fechaRegistro: String = "",
    var rol: String = "usuario"
)

data class Perfil(
    var usuarioId: Int = 0,
    var bio: String = "",
    var avatar: String = "",
    var preferencias: MutableMap<String, String> = mutableMapOf()
)

data class ConfiguracionSistema(
    var maxUsuarios: Int = 1000,
    var timeoutSesion: Int = 30,
    var modoDebug: Boolean = false,
    var notificaciones: Boolean = true
)

class GestorUsuarios {
    private val usuarios = mutableListOf<Usuario>()
    private val perfiles = mutableListOf<Perfil>()
    private val configuracion = ConfiguracionSistema()
    
    // Función que demuestra el uso de APPLY
    fun crearUsuarioConApply(datos: Map<String, Any>): Usuario {
        return Usuario().apply {
            // apply permite configurar el objeto y retorna el objeto configurado
            id = datos["id"] as? Int ?: generarId()
            nombre = datos["nombre"] as? String ?: ""
            email = datos["email"] as? String ?: ""
            telefono = datos["telefono"] as? String ?: ""
            activo = datos["activo"] as? Boolean ?: true
            fechaRegistro = obtenerFechaActual()
            rol = datos["rol"] as? String ?: "usuario"
            
            // Validar email antes de asignar
            if (!email.contains("@")) {
                email = "sin-email@default.com"
            }
        }
    }
    
    // Función que demuestra el uso de LET
    fun procesarUsuarioConLet(usuarioId: Int): String {
        return buscarUsuario(usuarioId)?.let { usuario ->
            // let permite ejecutar código solo si el objeto no es null
            // y retorna el resultado de la lambda
            val nombreFormateado = usuario.nombre.uppercase()
            val emailValido = if (usuario.email.contains("@")) "válido" else "inválido"
            "Usuario: $nombreFormateado, Email: $emailValido"
        } ?: "Usuario no encontrado"
    }
    
    // Función que demuestra el uso de ALSO
    fun registrarUsuarioConAlso(usuario: Usuario): Usuario {
        return usuario.also { u ->
            // also ejecuta código adicional y retorna el objeto original
            println("Registrando usuario: ${u.nombre}")
            usuarios.add(u)
            
            // Crear perfil por defecto
            val perfil = Perfil().apply {
                usuarioId = u.id
                bio = "Usuario nuevo"
                avatar = "default-avatar.png"
                preferencias["tema"] = "claro"
                preferencias["idioma"] = "es"
            }
            perfiles.add(perfil)
            
            println("Usuario ${u.nombre} registrado exitosamente")
        }
    }
    
    // Función que demuestra el uso de WITH
    fun configurarSistemaConWith(): ConfiguracionSistema {
        return with(configuracion) {
            // with permite acceder a las propiedades del objeto sin usar 'this'
            maxUsuarios = 2000
            timeoutSesion = 60
            modoDebug = true
            notificaciones = false
            
            // Retornar el objeto configurado
            this
        }
    }
    
    // Función que demuestra el uso de RUN
    fun inicializarSistemaConRun(): String {
        return run {
            // run ejecuta un bloque de código y retorna el resultado
            println("Inicializando sistema de gestión de usuarios...")
            
            // Configurar sistema
            configurarSistemaConWith()
            
            // Crear usuario administrador por defecto
            val admin = Usuario().apply {
                id = 1
                nombre = "Administrador"
                email = "admin@sistema.com"
                rol = "admin"
                fechaRegistro = obtenerFechaActual()
            }
            
            registrarUsuarioConAlso(admin)
            
            "Sistema inicializado con ${usuarios.size} usuarios"
        }
    }
    
    // Función que combina todas las funciones de ámbito
    fun procesarNuevoUsuario(datos: Map<String, Any>): String {
        return run {
            // RUN: Ejecutar lógica principal
            println("Procesando nuevo usuario...")
            
            // APPLY: Crear y configurar usuario
            val usuario = crearUsuarioConApply(datos)
            
            // ALSO: Registrar usuario y realizar acciones adicionales
            val usuarioRegistrado = registrarUsuarioConAlso(usuario)
            
            // LET: Procesar información del usuario
            val informacion = procesarUsuarioConLet(usuarioRegistrado.id)
            
            // WITH: Configurar sistema si es necesario
            with(configuracion) {
                if (usuarios.size >= maxUsuarios) {
                    println("¡Advertencia! Límite de usuarios alcanzado")
                }
            }
            
            // Retornar resultado
            "Usuario procesado: $informacion"
        }
    }
    
    // Funciones auxiliares
    private fun generarId(): Int = usuarios.size + 1
    
    private fun obtenerFechaActual(): String = java.time.LocalDate.now().toString()
    
    private fun buscarUsuario(id: Int): Usuario? = usuarios.find { it.id == id }
    
    fun listarUsuarios(): List<Usuario> = usuarios.toList()
    
    fun obtenerConfiguracion(): ConfiguracionSistema = configuracion
}

// Función principal que demuestra el uso de todas las funciones de ámbito
fun main() {
    println("=== SISTEMA DE GESTIÓN DE USUARIOS ===")
    println("Demostración de funciones de ámbito en Kotlin\n")
    
    val gestor = GestorUsuarios()
    
    // 1. Inicializar sistema con RUN
    println("1. Inicializando sistema...")
    val resultadoInicializacion = gestor.inicializarSistemaConRun()
    println("Resultado: $resultadoInicializacion\n")
    
    // 2. Configurar sistema con WITH
    println("2. Configurando sistema...")
    val configuracion = gestor.configurarSistemaConWith()
    println("Configuración actualizada: $configuracion\n")
    
    // 3. Crear usuarios con APPLY
    println("3. Creando usuarios...")
    val datosUsuario1 = mapOf(
        "nombre" to "Ana García",
        "email" to "ana.garcia@email.com",
        "telefono" to "3001234567",
        "rol" to "usuario"
    )
    
    val datosUsuario2 = mapOf(
        "nombre" to "Carlos López",
        "email" to "carlos.lopez@email.com",
        "telefono" to "3009876543",
        "rol" to "moderador"
    )
    
    val usuario1 = gestor.crearUsuarioConApply(datosUsuario1)
    val usuario2 = gestor.crearUsuarioConApply(datosUsuario2)
    
    println("Usuario 1 creado: $usuario1")
    println("Usuario 2 creado: $usuario2\n")
    
    // 4. Registrar usuarios con ALSO
    println("4. Registrando usuarios...")
    gestor.registrarUsuarioConAlso(usuario1)
    gestor.registrarUsuarioConAlso(usuario2)
    println()
    
    // 5. Procesar información con LET
    println("5. Procesando información de usuarios...")
    val infoUsuario1 = gestor.procesarUsuarioConLet(usuario1.id)
    val infoUsuario2 = gestor.procesarUsuarioConLet(usuario2.id)
    val infoUsuarioInexistente = gestor.procesarUsuarioConLet(999)
    
    println("Info usuario 1: $infoUsuario1")
    println("Info usuario 2: $infoUsuario2")
    println("Info usuario inexistente: $infoUsuarioInexistente\n")
    
    // 6. Procesar nuevo usuario combinando todas las funciones
    println("6. Procesando nuevo usuario con todas las funciones...")
    val datosNuevoUsuario = mapOf(
        "nombre" to "María Rodríguez",
        "email" to "maria.rodriguez@email.com",
        "telefono" to "3005551234",
        "rol" to "usuario"
    )
    
    val resultado = gestor.procesarNuevoUsuario(datosNuevoUsuario)
    println("Resultado: $resultado\n")
    
    // 7. Mostrar estado final
    println("7. Estado final del sistema:")
    println("Usuarios registrados: ${gestor.listarUsuarios().size}")
    gestor.listarUsuarios().forEach { usuario ->
        println("  - ${usuario.nombre} (${usuario.rol})")
    }
    
    println("\nConfiguración del sistema:")
    val configFinal = gestor.obtenerConfiguracion()
    println("  - Máximo usuarios: ${configFinal.maxUsuarios}")
    println("  - Timeout sesión: ${configFinal.timeoutSesion} minutos")
    println("  - Modo debug: ${configFinal.modoDebug}")
    println("  - Notificaciones: ${configFinal.notificaciones}")
    
    println("\n=== DEMOSTRACIÓN COMPLETADA ===")
} 