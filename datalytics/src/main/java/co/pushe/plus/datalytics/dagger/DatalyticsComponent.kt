package co.pushe.plus.datalytics.dagger

import android.content.Context
import co.pushe.plus.dagger.CoreComponent

@DatalyticsScope
interface DatalyticsComponent {
    fun context(): Context
}