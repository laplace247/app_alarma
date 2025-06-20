package com.empresa.appalarma.services

import com.empresa.appalarma.utils.NotificationHelper
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Este servicio se ejecuta en segundo plano y es el responsable de recibir
 * las notificaciones push enviadas desde Firebase Cloud Messaging (FCM).
 */
class FirebaseAlarmService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Extraemos el título y cuerpo de la notificación.
        // Usamos el operador elvis (?:) para proporcionar un texto por defecto si vienen vacíos.
        val title = remoteMessage.notification?.title ?: "¡Alerta de Seguridad!"
        val body = remoteMessage.notification?.body ?: "Se ha detectado una anomalía."

        // Usamos nuestra clase de ayuda para construir y mostrar la notificación de alarma.
        NotificationHelper(this).showAlarmNotification(title, body)
    }
}