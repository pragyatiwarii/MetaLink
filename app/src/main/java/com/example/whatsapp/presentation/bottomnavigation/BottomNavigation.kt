package com.example.whatsapp.presentation.bottomnavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsapp.R

@Preview(showSystemUi = true)
@Composable
fun BottomNavigation() {

    BottomAppBar(
        tonalElevation = 12.dp,
        containerColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // 👈 makes items spread evenly
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.chats),
                    contentDescription = "Chats",
                    modifier = Modifier.size(28.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "Chats", fontWeight = FontWeight.Bold, color = Color.Black)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.update_icon),
                    contentDescription = "Updates",
                    modifier = Modifier.size(28.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "Updates", fontWeight = FontWeight.Bold, color = Color.Black)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.communities_icon),
                    contentDescription = "Communities",
                    modifier = Modifier.size(28.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "Communities", fontWeight = FontWeight.Bold, color = Color.Black)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.telephone),
                    contentDescription = "Calls",
                    modifier = Modifier.size(28.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "Calls", fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}
