# Tarea 3 – Colecciones y Diseño Profesional

## Objetivo
Aplicar estructuras profesionales de programación creando un sistema de gestión de empleados que cumpla los requisitos obligatorios.

## Requisitos cumplidos
- Clase `Empleado` con `id`, `nombre`, `departamento`.
- Funcionalidades:
    - Añadir empleado
    - Buscar por id
    - Eliminar empleado
    - Listar empleados
    - Filtrar por departamento
- Uso obligatorio:
    - `ArrayList`
    - `HashMap`
    - Singleton
    - Factory
    - Lista enlazada artesanal (`Nodo` + `ListaEnlazada`)

## Estructura del proyecto
- `src/ColeccionesDiseñoProfesional/Empleado.java`
- `src/ColeccionesDiseñoProfesional/EmpleadoFactory.java`
- `src/ColeccionesDiseñoProfesional/GestorEmpleados.java`
- `src/ColeccionesDiseñoProfesional/Nodo.java`
- `src/ColeccionesDiseñoProfesional/ListaEnlazada.java`
- `src/ColeccionesDiseñoProfesional/MenuEmpleados.java`
- `src/Main.java` (punto de entrada único)

## Cómo ejecutar (JetBrains)
1. Clic derecho en `src/Main.java` → **Run 'Main'**.
2. Luego usa **Mayus+F10** para repetir la ejecución.

## Nota sobre caracteres (UTF-8)
El proyecto usa `ñ` en nombres de paquetes y métodos. Si ves errores:
- Ajusta la codificación a **UTF-8** en:  
  *File > Settings > Editor > File Encodings*.

## Ejemplo de uso
El menú permite:
1. Añadir empleado
2. Buscar por ID
3. Eliminar empleado
4. Listar empleados
5. Filtrar por departamento
6. Salir

