import java.time.LocalDate

data class Biblioteca(
    val id: Int,
    var nombre: String,
    var direccion: String,
    var fechaInauguracion: LocalDate,
    var abiertaAlPublico: Boolean,
    val libros: MutableList<Libro> = mutableListOf()
) {
    // Agregar un libro a la biblioteca
    fun agregarLibro(libro: Libro) {
        libros.add(libro)
    }

    // Eliminar un libro por su ID
    fun eliminarLibro(idLibro: Int) {
        libros.removeIf { it.id == idLibro }
    }

    // Listar libros de la biblioteca
    fun listarLibros() {
        println("Libros en la biblioteca '$nombre':")
        libros.forEach { println(it) }
    }
}
