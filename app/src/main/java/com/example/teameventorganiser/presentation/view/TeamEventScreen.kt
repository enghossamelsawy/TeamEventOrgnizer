/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.teameventorganiser.presentation.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.teameventorganiser.core.data.Event

/**
 * Screen metadata for Rally.
 */
enum class TeamEventScreen(
    val icon: ImageVector,
    val event: Event?= null
) {
    SignIn(icon = Icons.Filled.PieChart ),
    Home(
        icon = Icons.Filled.AttachMoney
    ),
    Details(
        icon = Icons.Filled.MoneyOff
    ),

    Participate(
        icon = Icons.Filled.MoneyOff
    );

    @Composable
    fun content(onScreenChange: (String) -> Unit) {
//        body(onScreenChange)
    }


}

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object SignIn : NavRoutes("signIn")
    object Profile : NavRoutes("profile")
}
