package com.example.whatsapp.presentation.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.R
import com.example.whatsapp.presentation.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {

    // Navigate to welcome screen after 1 sec
    LaunchedEffect(Unit) {
        delay(1000)
        navHostController.navigate(Routes.WelcomeScreen.route) {
            popUpTo(Routes.SplashScreen.route) { inclusive = true } // Prevent back navigation to Splash
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
    ) {
        // Center WhatsApp Logo
        Image(
            painter = painterResource(id = R.drawable.whatsapp_icon),
            contentDescription = "WhatsApp Logo",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.Center)
        )

        // Bottom "From Meta"
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "From",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.meta),
                    contentDescription = "Meta Logo",
                    modifier = Modifier.size(24.dp),
                    tint = colorResource(R.color.light_green)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Meta",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen(navHostController = rememberNavController())
}
