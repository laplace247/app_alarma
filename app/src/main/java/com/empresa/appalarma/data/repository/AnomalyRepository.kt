package com.empresa.appalarma.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.empresa.appalarma.data.model.Anomaly
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * AnomalyRepository es el intermediario entre la fuente de datos (Firebase) y el ViewModel.
 * Su responsabilidad es obtener y exponer la lista de anomalías en tiempo real.
 */
class AnomalyRepository {
    // Apuntamos específicamente al nodo "anomalies" donde el ESP32 guardará los datos.
    private val database = Firebase.database.getReference("anomalies")

    // LiveData cuyo valor puede ser modificado (privado para que solo el repositorio lo haga).
    private val _anomalies = MutableLiveData<List<Anomaly>>()

    // Versión pública y de solo lectura que expondremos al ViewModel.
    val anomalies: LiveData<List<Anomaly>> = _anomalies

    init {
        // Comenzamos a escuchar los cambios en Firebase en cuanto se crea el repositorio.
        listenForAnomalies()
    }

    private fun listenForAnomalies() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anomalyList = mutableListOf<Anomaly>()
                for (anomalySnapshot in snapshot.children) {
                    val anomaly = anomalySnapshot.getValue(Anomaly::class.java)
                    anomaly?.let { anomalyList.add(it) }
                }
                // Actualizamos el LiveData, invirtiendo la lista para que lo más nuevo aparezca arriba.
                _anomalies.value = anomalyList.reversed()
            }

            override fun onCancelled(error: DatabaseError) {
                // Aquí se podría manejar un error de lectura de la base de datos.
            }
        })
    }
}