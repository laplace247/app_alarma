package com.empresa.appalarma.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.empresa.appalarma.R
import com.empresa.appalarma.data.model.Anomaly

/**
 * AnomalyAdapter es el responsable de tomar la lista de datos (anomalías)
 * y vincularla con las vistas de cada fila del RecyclerView.
 */
class AnomalyAdapter : RecyclerView.Adapter<AnomalyAdapter.AnomalyViewHolder>() {

    // Lista interna que contendrá los datos a mostrar.
    private var anomalyList = emptyList<Anomaly>()

    /**
     * ViewHolder: Representa una única fila en la lista.
     * Contiene las referencias a las vistas (TextViews, etc.) dentro de esa fila.
     * Esto evita hacer llamadas a 'findViewById' repetidamente, lo cual es muy eficiente.
     */
    class AnomalyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timestampTextView: TextView = itemView.findViewById(R.id.textViewTimestamp)
        val locationTextView: TextView = itemView.findViewById(R.id.textViewLocation)
    }

    /**
     * Se llama cuando el RecyclerView necesita crear un nuevo ViewHolder (una nueva fila).
     * Infla el layout XML de la fila y lo devuelve dentro de un AnomalyViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnomalyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anomaly, parent, false) // Asegúrate de tener 'item_anomaly.xml'
        return AnomalyViewHolder(view)
    }

    /**
     * Se llama para vincular los datos de una anomalía específica (en la posición 'position')
     * con las vistas del ViewHolder.
     */
    override fun onBindViewHolder(holder: AnomalyViewHolder, position: Int) {
        val currentAnomaly = anomalyList[position]
        holder.timestampTextView.text = currentAnomaly.timestamp
        holder.locationTextView.text = currentAnomaly.location
    }

    /**
     * Devuelve el número total de ítems en la lista.
     * El RecyclerView lo usa para saber cuántas filas debe dibujar.
     */
    override fun getItemCount(): Int {
        return anomalyList.size
    }

    /**
     * Función personalizada para actualizar la lista de datos del adaptador.
     * Cuando la lista cambia, notifica al RecyclerView para que se redibuje.
     */
    fun setData(newAnomalyList: List<Anomaly>) {
        this.anomalyList = newAnomalyList
        notifyDataSetChanged() // Notifica que los datos han cambiado y la lista debe refrescarse.
    }
}