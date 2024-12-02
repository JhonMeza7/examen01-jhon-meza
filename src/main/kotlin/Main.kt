import services.CrudService
import services.FileStorageService
import java.time.LocalDate

fun main() {
    val bibliotecas = mutableListOf<Biblioteca>()

    println("Crear Bibliotecas\n")
    // Crear bibliotecas
    val biblioteca1 = CrudService.crearBiblioteca(1, "Biblioteca Central", "Calle 123", LocalDate.of(2000, 1, 1), true)
    val biblioteca2 = CrudService.crearBiblioteca(2, "Biblioteca Secundaria", "Calle 456", LocalDate.of(2010, 5, 15), false)

    bibliotecas.add(biblioteca1)
    bibliotecas.add(biblioteca2)
    println("Crear libros\n")
    // Crear libros
    val libro1 = CrudService.crearLibro(1, "Kotlin desde Cero", "Juan Pérez", 29.99, LocalDate.of(2021, 6, 10))
    val libro2 = CrudService.crearLibro(2, "Avanzado en Kotlin", "Ana Gómez", 49.99, LocalDate.of(2023, 3, 5))

    println("Agregar libros a la biblioteca\n")
    // Agregar libros a la biblioteca
    biblioteca1.agregarLibro(libro1)
    biblioteca1.agregarLibro(libro2)

    println("Guardar bibliotecas en archivo\n")
    // Guardar bibliotecas en archivo
    FileStorageService.guardarBibliotecasEnArchivo(bibliotecas, "bibliotecas.txt")
    println("Cargar bibliotecas desde archivo\n \n")
    // Cargar bibliotecas desde archivo
    val bibliotecasDesdeArchivo = FileStorageService.cargarBibliotecasDesdeArchivo("bibliotecas.txt")
    bibliotecasDesdeArchivo.forEach {
        println(it)
        it.listarLibros()
    }
}
