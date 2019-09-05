package co.pushe.plus.notification.dagger

import android.content.Context

@NotificationScope
interface NotificationComponent {
    fun context(): Context
}
