package com.rpfcoding.handleerrorswithcleanarchapp.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    class StringResource(
        @StringRes val id: Int,
        val args: Array<Any> = emptyArray()
    ) : UiText()

    @Composable
    fun asString(): String {
        return when(this) {
            is DynamicString -> value
            is StringResource -> stringResource(id, args)
        }
    }

    // If you are still using XML, need to pass context.
    fun asString(ctx: Context): String {
        return when(this) {
            is DynamicString -> value
            is StringResource -> ctx.getString(id, args)
        }
    }
}
