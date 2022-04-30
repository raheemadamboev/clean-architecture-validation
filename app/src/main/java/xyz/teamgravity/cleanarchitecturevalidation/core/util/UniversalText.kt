package xyz.teamgravity.cleanarchitecturevalidation.core.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UniversalText {
    data class Dynamic(val value: String) : UniversalText()
    class Resource(@StringRes val id: Int, vararg val args: Any) : UniversalText()

    @Composable
    fun asString(): String {
        return when (this) {
            is Dynamic -> value
            is Resource -> stringResource(id = id, formatArgs = args)
        }
    }

    fun asString(context: Context): String {
        return when (this) {
            is Dynamic -> value
            is Resource -> context.getString(id, *args)
        }
    }
}