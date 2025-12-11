package com.minasamir.organizationstructure_android.organizationStructure

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.core.os.ConfigurationCompat
import androidx.core.os.LocaleListCompat
import java.util.Locale

@Composable
@ReadOnlyComposable
fun currentLocale(): Locale {
    val configuration = LocalConfiguration.current
    return ConfigurationCompat.getLocales(configuration)[0]
        ?: LocaleListCompat.getAdjustedDefault()[0]!!
}

@Composable
@ReadOnlyComposable
fun isRTL(): Boolean {
    return currentLocale().language == "ar"
}

@Composable
@ReadOnlyComposable
fun isLTR(): Boolean {
    return !isRTL()
}