package co.pushe.plus.analytics.dagger

import android.content.Context
import co.pushe.plus.dagger.CoreComponent

@AnalyticsScope
interface AnalyticsComponent {
    fun context(): Context
}
