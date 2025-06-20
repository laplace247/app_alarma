package com.empresa.appalarma.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.empresa.appalarma.data.model.Anomaly
import com.empresa.appalarma.data.repository.AnomalyRepository

/**
 * MainViewModel es el puente entre la lógica de datos (Repository) y la UI (Activity).
 * Sobrevive a cambios de configuración, como la rotación de la pantalla.
 */
class MainViewModel : ViewModel() {

    // 1. Creamos una instancia de nuestro repositorio de datos.
    private val repository = AnomalyRepository()

    // 2. Exponemos el LiveData de las anomalías desde el repositorio.
    // La Activity observará esta variable para recibir actualizaciones de la lista.
    // No necesitamos un _anomalies privado aquí, porque el ViewModel solo está
    // "pasando" el LiveData del repositorio.
    val anomalies: LiveData<List<Anomaly>> = repository.anomalies

}