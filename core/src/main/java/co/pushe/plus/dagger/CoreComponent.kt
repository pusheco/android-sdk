package co.pushe.plus.dagger

import android.content.Context
import android.content.SharedPreferences

@CoreScope
interface CoreComponent {
    fun context(): Context
    fun sharedPreferences(): SharedPreferences
}
