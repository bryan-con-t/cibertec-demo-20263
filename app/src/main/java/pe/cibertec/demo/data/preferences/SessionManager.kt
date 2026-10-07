package pe.cibertec.demo.data.preferences

import android.content.Context

class SessionManager(
    context: Context
) {
    private val preferences = context.getSharedPreferences(
        "lista_compras_sesion",
        Context.MODE_PRIVATE
    )

    fun saveSession(
        userId: Int,
        userName: String
    ) {
        preferences.edit()
            .putBoolean("logged", true)
            .putInt("user_id", userId)
            .putString("user_name", userName)
            .apply()
    }

    fun isLogged(): Boolean {
        return preferences.getBoolean("logged", false)
    }

    fun clearSession() {
        preferences.edit()
            .clear()
            .apply()
    }
}
