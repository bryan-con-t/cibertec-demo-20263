package pe.cibertec.demo.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(
    context: Context
): SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                correo TEXT NOT NULL,
                clave TEXT NOT NULL
            )
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE listas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                usuario_id INTEGER NOT NULL,
                nombre TEXT NOT NULL,
                fecha TEXT NOT NULL,
                FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
            )
        """.trimIndent())

        db.execSQL("""
            CREATE TABLE detalle_lista (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                lista_id INTEGER NOT NULL,
                nombre TEXT NOT NULL,
                cantidad INTEGER NOT NULL,
                categoria TEXT NOT NULL,
                precio REAL NOT NULL,
                comprado INTEGER NOT NULL DEFAULT 0,
                descuento REAL NOT NULL DEFAULT 0,
                FOREIGN KEY (lista_id) REFERENCES listas(id)
            )
        """.trimIndent())
    }

    // ROLLBACK
    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS detalle_lista")
        db.execSQL("DROP TABLE IF EXISTS listas")
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "cibertec_demo.db"
        private const val DATABASE_VERSION = 1
    }
}