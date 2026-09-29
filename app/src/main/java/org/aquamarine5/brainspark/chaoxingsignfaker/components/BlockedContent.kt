package org.aquamarine5.brainspark.chaoxingsignfaker.components

import androidx.compose.runtime.Composable

@Composable
fun BlockedContent(content: @Composable () -> Unit) {
    content()
}