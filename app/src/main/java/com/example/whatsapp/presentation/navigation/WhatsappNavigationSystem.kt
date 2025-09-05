package com.example.whatsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.presentation.callscreen.CallScreen
import com.example.whatsapp.presentation.community.CommunityScreen
import com.example.whatsapp.presentation.homescreen.HomeScreen
import com.example.whatsapp.presentation.splashscreen.SplashScreen
import com.example.whatsapp.presentation.updatescreen.UpdateScreen
import com.example.whatsapp.presentation.userregistrationscreen.UserRegistrationScreen
import com.example.whatsapp.presentation.welcomescreen.WelcomeScreen

@Composable
fun WhatsappNavigationSystem() {
    val navController = rememberNavController()

    /*NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen
    ) {
        // Navigation Graph
        composable<Routes.SplashScreen> {
            SplashScreen(navController)
        }
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }
        composable<Routes.UserRegisterScreen> {
            UserRegistrationScreen()
        }
        composable<Routes.HomeScreen> {
            HomeScreen()
        }

        composable<Routes.UpdateScreen> {
            UpdateScreen()
        }
        composable<Routes.CommunityScreen> {
            CommunityScreen()
        }
        composable<Routes.CallScreen> {
            CallScreen()
        }
    }*/
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        // Navigation Graph
        composable(Routes.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Routes.WelcomeScreen.route) {
            WelcomeScreen(navController)
        }
        composable(Routes.UserRegisterScreen.route) {
            UserRegistrationScreen()
        }
        composable(Routes.HomeScreen.route) {
            HomeScreen()
        }
        composable(Routes.UpdateScreen.route) {
            UpdateScreen()
        }
        composable(Routes.CommunityScreen.route) {
            CommunityScreen()
        }
        composable(Routes.CallScreen.route) {
            CallScreen()
        }
    }

}

