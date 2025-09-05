/*package com.example.whatsapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object SplashScreen: Routes()

    @Serializable
    data object WelcomeScreen: Routes()

    @Serializable
    data object UserRegisterScreen: Routes()

    @Serializable
    data object HomeScreen: Routes()

    @Serializable
    data object UpdateScreen: Routes()
    @Serializable
    data object CommunityScreen: Routes()

    @Serializable
    data object CallScreen: Routes()

}*/

package com.example.whatsapp.presentation.navigation

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash")
    object WelcomeScreen : Routes("welcome")
    object UserRegisterScreen : Routes("register")
    object HomeScreen : Routes("home")
    object UpdateScreen : Routes("update")
    object CommunityScreen : Routes("community")
    object CallScreen : Routes("call")
}
