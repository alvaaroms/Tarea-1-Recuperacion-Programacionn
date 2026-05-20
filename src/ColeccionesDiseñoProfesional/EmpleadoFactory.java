package ColeccionesDiseñoProfesional;

public class EmpleadoFactory {

    // Método estático para fabricar empleados
    public static Empleado crearEmpleado(int id, String nombre, String departamento) {
        // Aquí podríamos añadir validaciones en el futuro (ej. que el nombre no esté vacío)
        // Por ahora, simplemente construye y devuelve el objeto
        return new Empleado(id, nombre, departamento);
    }
}
