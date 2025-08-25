# Índice de Programación Funcional en Kotlin

Este repositorio ahora incluye ejemplos completos de los pilares de la programación funcional y las funciones de ámbito de Kotlin, creados como material de apoyo para el espacio académico de Construcción de Aplicaciones Móviles.

## 📁 Estructura del Repositorio

```
taller-manual-kotlin/
├── src/                           # Código original del taller
│   ├── Main.kt
│   ├── entities/
│   ├── enum/
│   ├── interfaces/
│   ├── repositories/
│   └── services/
├── programacion-funcional/        # ✨ NUEVO: Ejemplos de programación funcional
│   ├── README.md                  # Documentación completa
│   ├── ejecutar-ejemplos.kt       # Script para ejecutar todos los ejemplos
│   ├── 1-inmutabilidad.kt         # Ejemplos de inmutabilidad
│   ├── 2-funciones-puras.kt       # Ejemplos de funciones puras
│   ├── 3-funciones-orden-superior.kt # Ejemplos de funciones de orden superior
│   ├── 4-composicion-funciones.kt # Ejemplos de composición de funciones
│   ├── 5-evaluacion-perezosa.kt   # Ejemplos de evaluación perezosa
│   └── 6-funciones-ambito.kt      # Ejemplo práctico con funciones de ámbito
└── Construcción de aplicaciones móviles _ Documentos de apoyo...pdf
```

## 🎯 Contenido Agregado

### Pilares de la Programación Funcional

Cada pilar incluye **dos ejemplos prácticos** que ilustran los conceptos:

1. **Inmutabilidad** (`1-inmutabilidad.kt`)
   - Listas inmutables vs mutables
   - Clases de datos inmutables con `copy()`

2. **Funciones Puras** (`2-funciones-puras.kt`)
   - Funciones matemáticas puras
   - Funciones de strings puras
   - Comparación con funciones no puras

3. **Funciones de Orden Superior** (`3-funciones-orden-superior.kt`)
   - Funciones que toman funciones como parámetros
   - Funciones que retornan funciones
   - Combinación de ambos conceptos

4. **Composición de Funciones** (`4-composicion-funciones.kt`)
   - Composición básica de funciones
   - Composición con strings
   - Composición avanzada con listas

5. **Evaluación Perezosa** (`5-evaluacion-perezosa.kt`)
   - Secuencias (Sequences) vs listas
   - Propiedades lazy
   - Evaluación perezosa con funciones

### Funciones de Ámbito

6. **Sistema de Gestión de Usuarios** (`6-funciones-ambito.kt`)
   - **Ejemplo práctico completo** que usa las cinco funciones de ámbito:
     - `apply`: Configurar objetos
     - `let`: Manejo seguro de nulls
     - `also`: Acciones adicionales
     - `with`: Acceso a propiedades
     - `run`: Ejecución de bloques de código

## 🚀 Cómo Usar los Ejemplos

### Ejecutar ejemplos individuales:

```bash
cd programacion-funcional

# Compilar y ejecutar un ejemplo específico
kotlinc 1-inmutabilidad.kt -include-runtime -d inmutabilidad.jar
java -jar inmutabilidad.jar

# O ejecutar el script que incluye todos los ejemplos
kotlinc ejecutar-ejemplos.kt -include-runtime -d todos-los-ejemplos.jar
java -jar todos-los-ejemplos.jar
```

### Ejecutar todos los ejemplos de una vez:

```bash
cd programacion-funcional
kotlinc ejecutar-ejemplos.kt -include-runtime -d todos-los-ejemplos.jar
java -jar todos-los-ejemplos.jar
```

## 📚 Conceptos Cubiertos

### Programación Funcional
- ✅ **Inmutabilidad**: Datos que no se modifican una vez creados
- ✅ **Funciones Puras**: Funciones sin efectos secundarios
- ✅ **Funciones de Orden Superior**: Funciones que toman/retornan funciones
- ✅ **Composición de Funciones**: Combinar funciones para crear nuevas funcionalidades
- ✅ **Evaluación Perezosa**: Solo evaluar cuando es necesario

### Funciones de Ámbito de Kotlin
- ✅ **apply**: Configurar objetos y retornar el objeto configurado
- ✅ **let**: Ejecutar código solo si el objeto no es null
- ✅ **also**: Ejecutar código adicional y retornar el objeto original
- ✅ **with**: Acceder a propiedades del objeto sin usar 'this'
- ✅ **run**: Ejecutar un bloque de código y retornar el resultado

## 🎓 Objetivos Educativos

Estos ejemplos están diseñados para:

1. **Ilustrar conceptos** de programación funcional de manera práctica
2. **Demostrar el uso** de las funciones de ámbito de Kotlin
3. **Proporcionar casos de uso reales** en aplicaciones móviles
4. **Facilitar el aprendizaje** con ejemplos ejecutables
5. **Servir como referencia** para el desarrollo de aplicaciones

## 📖 Documentación

- **README.md** en `programacion-funcional/`: Documentación completa con explicaciones detalladas
- **Comentarios en el código**: Cada ejemplo incluye comentarios explicativos
- **Casos de uso prácticos**: Ejemplos que se pueden aplicar en aplicaciones reales

## 🔧 Requisitos Técnicos

- Kotlin 1.3 o superior
- Java 8 o superior
- Compilador de Kotlin (kotlinc)

## 📝 Notas Importantes

- Los ejemplos están **separados del código original** del taller
- Cada archivo es **independiente** y se puede ejecutar por separado
- El código incluye **comentarios explicativos** en español
- Los ejemplos son **educativos** y están diseñados para el aprendizaje
- Se incluye un **script consolidado** para ejecutar todos los ejemplos

---

**Material creado para el espacio académico de Construcción de Aplicaciones Móviles** 