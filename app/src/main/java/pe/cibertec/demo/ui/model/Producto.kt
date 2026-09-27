package pe.cibertec.demo.ui.model

data class Producto (
    val nombre: String,
    val precio: Double,
    val cantidad: Int,
    val categoria: String,
    val estado: String,
    val comprado: Boolean = false,
    val imagen: String? = null,
) {
    fun subtotal() : Double {
        return precio * cantidad
    }

    fun marcarComoComprado(): Producto = copy(comprado = true)

    fun marcarComoPendiente(): Producto = copy(comprado = false)
}
