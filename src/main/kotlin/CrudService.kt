package services

import Biblioteca
import Libro
import java.time.LocalDate

object CrudService {
    fun crearBiblioteca(id: Int, nombre: String, direccion: String, fechaInauguracion: LocalDate, abiertaAlPublico: Boolean): Biblioteca {
        return Biblioteca(id, nombre, direccion, fechaInauguracion, abiertaAlPublico)
    }

    fun actualizarBiblioteca(biblioteca: Biblioteca, nuevoNombre: String, nuevaDireccion: String) {
        biblioteca.nombre = nuevoNombre
        biblioteca.direccion = nuevaDireccion
    }

    fun eliminarBiblioteca(bibliotecas: MutableList<Biblioteca>, id: Int) {
        bibliotecas.removeIf { it.id == id }
    }

    fun leerBibliotecas(bibliotecas: List<Biblioteca>) {
        bibliotecas.forEach { println(it) }
    }

    fun crearLibro(id: Int, titulo: String, autor: String, precio: Double, fechaPublicacion: LocalDate): Libro {
        return Libro(id, titulo, autor, precio, fechaPublicacion)
    }

    fun actualizarLibro(libro: Libro, nuevoTitulo: String, nuevoPrecio: Double) {
        libro.titulo = nuevoTitulo
        libro.precio = nuevoPrecio
    }

    fun eliminarLibro(libros: MutableList<Libro>, id: Int) {
        libros.removeIf { it.id == id }
    }

    fun leerLibros(libros: List<Libro>) {
        libros.forEach { println(it) }
    }
}
