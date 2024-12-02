import java.time.LocalDate

data class Libro(
    val id: Int,
    var titulo: String,
    var autor: String,
    var precio: Double,
    var fechaPublicacion: LocalDate
)
