package co.pushe.plus.logcollection.dagger

import android.content.Context

@LogCollectionScope
interface LogCollectionComponent {
    fun context() : Context
}
