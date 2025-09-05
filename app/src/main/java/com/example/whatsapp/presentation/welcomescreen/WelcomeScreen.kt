package com.example.whatsapp.presentation.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.R
import com.example.whatsapp.presentation.navigation.Routes

@Composable
fun WelcomeScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // WhatsApp Logo
            Image(
                painter = painterResource(id = R.drawable.whatsapp_icon),
                contentDescription = "WhatsApp Logo",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Welcome text
            Text(
                text = "Welcome to WhatsApp",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Continue button
            Button(
                onClick = {
                    navHostController.navigate(Routes.HomeScreen.route) {
                        popUpTo(Routes.WelcomeScreen.route) { inclusive = true }
                    }
                }
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen(navHostController = rememberNavController())
}
