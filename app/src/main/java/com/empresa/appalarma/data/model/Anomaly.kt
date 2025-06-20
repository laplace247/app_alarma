package com.empresa.appalarma.data.model

/**
 * Representa un único evento de anomalía.
 * Es una data class para obtener automáticamente funciones útiles como toString(), equals(), etc.
 */
data class Anomaly(
    val timestamp: String = "",
    val location: String = "Sala de Estar"
) {
    /**
     * Constructor vacío requerido por Firebase Realtime Database para deserializar los datos.
     * Sin esto, la app fallaría al intentar leer los datos.
     */
    constructor() : this("", "")
}