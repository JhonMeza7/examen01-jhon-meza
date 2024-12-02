package services

import Biblioteca
import Libro
import java.io.File
import java.time.LocalDate

object FileStorageService {
    fun guardarBibliotecasEnArchivo(bibliotecas: List<Biblioteca>, nombreArchivo: String) {
        val file = File(nombreArchivo)
        file.printWriter().use { out ->
            bibliotecas.forEach { biblioteca ->
                out.println("${biblioteca.id},${biblioteca.nombre},${biblioteca.direccion},${biblioteca.fechaInauguracion},${biblioteca.abiertaAlPublico}")
                biblioteca.libros.forEach { libro ->
                    out.println("  ${libro.id},${libro.titulo},${libro.autor},${libro.precio},${libro.fechaPublicacion}")
                }
            }
        }
        println("Bibliotecas guardadas en el archivo '$nombreArchivo'.")
    }

    fun cargarBibliotecasDesdeArchivo(nombreArchivo: String): List<Biblioteca> {
        val file = File(nombreArchivo)
        val bibliotecas = mutableListOf<Biblioteca>()
        var bibliotecaActual: Biblioteca? = null

        if (file.exists()) {
            file.readLines().forEach { line ->
                if (!line.startsWith("  ")) { // Línea de biblioteca
                    // Si ya hay una biblioteca actual, asegúrate de agregarla antes de crear una nueva
                    bibliotecaActual?.let { bibliotecas.add(it) }

                    val parts = line.split(",")
                    bibliotecaActual = Biblioteca(
                        id = parts[0].toInt(),
                        nombre = parts[1],
                        direccion = parts[2],
                        fechaInauguracion = LocalDate.parse(parts[3]),
                        abiertaAlPublico = parts[4].toBoolean()
                    )
                } else { // Línea de libro
                    val parts = line.trim().split(",")
                    bibliotecaActual?.agregarLibro(
                        Libro(
                            id = parts[0].toInt(),
                            titulo = parts[1],
                            autor = parts[2],
                            precio = parts[3].toDouble(),
                            fechaPublicacion = LocalDate.parse(parts[4])
                        )
                    )
                }
            }

            // Agregar la última biblioteca procesada
            bibliotecaActual?.let { bibliotecas.add(it) }
        }

        return bibliotecas
    }

}
