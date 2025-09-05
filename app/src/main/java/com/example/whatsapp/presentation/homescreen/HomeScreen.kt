package com.example.whatsapp.presentation.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {

    val chatList = listOf(
        ChatListModel(R.drawable.salman_khan, "Salman Khan", "Swagat nahi karoge hamara", "10:00 AM"),
        ChatListModel(R.drawable.sharukh_khan, "Shahrukh Khan", "Ae-e-e-e Kiran", "11:00 AM"),
        ChatListModel(R.drawable.rashmika, "Rashmika", "Dil se dil tak", "01:00 AM"),
        ChatListModel(R.drawable.sharadha_kapoor, "Shraddha Kapoor", "OK Jaanu", "04:00 AM")
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: New Chat Action */ },
                containerColor = colorResource(R.color.light_green),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(R.drawable.chat_icon),
                    contentDescription = "New Chat",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Whatsapp",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.light_green)
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = { /* Camera */ }) {
                    Icon(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = "Camera",
                        modifier = Modifier.size(24.dp)
                    )
                }

                IconButton(onClick = { /* Search */ }) {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp)
                    )
                }

                IconButton(onClick = { /* More */ }) {
                    Icon(
                        painter = painterResource(R.drawable.more),
                        contentDescription = "More Options",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)

            // Chat List
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(chatList) { chat ->
                    ChatDesign(chat = chat)
                }
            }
        }
    }
}
