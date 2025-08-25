# Programación Funcional en Kotlin

Este directorio contiene ejemplos prácticos de los pilares fundamentales de la programación funcional y las funciones de ámbito de Kotlin.

## 📁 Estructura de Archivos

### Pilares de la Programación Funcional

1. **`1-inmutabilidad.kt`** - Ejemplos de inmutabilidad
   - Listas inmutables vs mutables
   - Clases de datos inmutables con `copy()`

2. **`2-funciones-puras.kt`** - Ejemplos de funciones puras
   - Funciones matemáticas puras
   - Funciones de strings puras
   - Comparación con funciones no puras

3. **`3-funciones-orden-superior.kt`** - Ejemplos de funciones de orden superior
   - Funciones que toman funciones como parámetros
   - Funciones que retornan funciones
   - Combinación de ambos conceptos

4. **`4-composicion-funciones.kt`** - Ejemplos de composición de funciones
   - Composición básica de funciones
   - Composición con strings
   - Composición avanzada con listas

5. **`5-evaluacion-perezosa.kt`** - Ejemplos de evaluación perezosa
   - Secuencias (Sequences) vs listas
   - Propiedades lazy
   - Evaluación perezosa con funciones

### Funciones de Ámbito

6. **`6-funciones-ambito.kt`** - Ejemplo práctico completo
   - Sistema de gestión de usuarios
   - Uso de las 5 funciones de ámbito: `apply`, `let`, `also`, `with`, `run`

## 🚀 Cómo Ejecutar los Ejemplos

### Ejecutar ejemplos individuales:

```bash
# Compilar y ejecutar ejemplos específicos
kotlinc 1-inmutabilidad.kt -include-runtime -d inmutabilidad.jar
java -jar inmutabilidad.jar

kotlinc 2-funciones-puras.kt -include-runtime -d funciones-puras.jar
java -jar funciones-puras.jar

# Y así sucesivamente para cada archivo...
```

### Ejecutar todos los ejemplos:

```bash
# Script para ejecutar todos los ejemplos
for file in *.kt; do
    echo "=== Ejecutando $file ==="
    kotlinc "$file" -include-runtime -d "${file%.kt}.jar"
    java -jar "${file%.kt}.jar"
    echo ""
done
```

## 📚 Conceptos Explicados

### Pilares de la Programación Funcional

#### 1. Inmutabilidad
- Los datos no se modifican una vez creados
- Se crean nuevas instancias en lugar de modificar las existentes
- Beneficios: thread-safety, predictibilidad, facilita debugging

#### 2. Funciones Puras
- Siempre producen el mismo resultado para los mismos inputs
- No tienen efectos secundarios
- Beneficios: testabilidad, reutilización, razonamiento sobre el código

#### 3. Funciones de Orden Superior
- Funciones que toman otras funciones como parámetros
- Funciones que retornan funciones
- Beneficios: abstracción, flexibilidad, reutilización de código

#### 4. Composición de Funciones
- Combinar funciones para crear nuevas funcionalidades
- Crear pipelines de procesamiento
- Beneficios: modularidad, legibilidad, mantenibilidad

#### 5. Evaluación Perezosa
- Solo evaluar expresiones cuando son necesarias
- Beneficios: eficiencia, manejo de colecciones infinitas, optimización

### Funciones de Ámbito de Kotlin

#### `apply`
- Configura un objeto y retorna el objeto configurado
- Útil para inicialización de objetos
- Sintaxis: `objeto.apply { /* configuración */ }`

#### `let`
- Ejecuta código solo si el objeto no es null
- Retorna el resultado de la lambda
- Sintaxis: `objeto?.let { /* código */ }`

#### `also`
- Ejecuta código adicional y retorna el objeto original
- Útil para logging, validaciones, efectos secundarios
- Sintaxis: `objeto.also { /* código adicional */ }`

#### `with`
- Permite acceder a las propiedades del objeto sin usar 'this'
- Retorna el resultado de la lambda
- Sintaxis: `with(objeto) { /* código */ }`

#### `run`
- Ejecuta un bloque de código y retorna el resultado
- Útil para lógica compleja o inicialización
- Sintaxis: `objeto.run { /* código */ }` o `run { /* código */ }`

## 🎯 Casos de Uso Prácticos

### Inmutabilidad
- Configuraciones de sistema
- Datos de solo lectura
- Estados de aplicación

### Funciones Puras
- Cálculos matemáticos
- Validaciones
- Transformaciones de datos

### Funciones de Orden Superior
- Filtrado y mapeo de colecciones
- Callbacks
- Estrategias de procesamiento

### Composición de Funciones
- Pipelines de datos
- Validación en cadena
- Transformaciones complejas

### Evaluación Perezosa
- Procesamiento de grandes datasets
- Generación de secuencias infinitas
- Optimización de rendimiento

### Funciones de Ámbito
- Inicialización de objetos
- Manejo seguro de nulls
- Logging y debugging
- Configuración de sistemas


## 📖 Recursos Adicionales

- [Documentación oficial de Kotlin](https://kotlinlang.org/docs/home.html)
- [Kotlin Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib/)
- [Programación Funcional en Kotlin](https://kotlinlang.org/docs/functions.html)
