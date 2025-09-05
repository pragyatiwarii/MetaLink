package com.example.whatsapp.presentation.updatescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R
import com.example.whatsapp.presentation.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)
fun UpdateScreen() {
    val sampleStatusData = listOf(
        StatusData(R.drawable.bhuvan_bam, "My Status", "Tap to add status update", isMyStatus = true),
        StatusData(R.drawable.disha_patani, "Disha Patani", "10 min ago"),
        StatusData(R.drawable.kartik_aaryan, "Kartik Aryan", "2 min ago"),
        StatusData(R.drawable.carryminati, "CarryMinati", "Just Now")
    )

    val sampleChannels = listOf(
        Channels(Imagess = R.drawable.neat_roots, channel_name = "Neat Roots", channel_details = "Latest news in Tech"),
        Channels(Imagess = R.drawable.img, channel_name = "Food Lovers", channel_details = "Delicious Food Updates"),
        Channels(Imagess = R.drawable.meta, channel_name = "Meta", channel_details = "Discover the world")
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO */ },
                containerColor = colorResource(R.color.light_green),
                modifier = Modifier.size(65.dp),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_photo_camera_24),
                    contentDescription = "Open Camera",
                    modifier = Modifier.size(28.dp)
                )
            }
        },
        bottomBar = { BottomNavigation() },
        topBar = { TopBar() } // ⚠️ Make sure TopBar() exists
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Section: Status
            item {
                Text(
                    text = "Status",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = Color.Black
                )
            }

            items(sampleStatusData) { status ->
                StatusItem(statusData = status)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = Color.Gray)
            }

            // Section: Channels
            item {
                Text(
                    text = "Channels",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text(text = "Stay updated on topics that matter to you. Find channels to follow more.")

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "Find Channels to follow",
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            // ✅ Correct way to add channel items
            items(sampleChannels) { channel ->
                ChannelItemDesign(channels = channel)
            }
        }
    }
}
