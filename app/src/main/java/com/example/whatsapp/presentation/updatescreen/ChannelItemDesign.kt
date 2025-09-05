package com.example.whatsapp.presentation.updatescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Composable
fun ChannelItemDesign(channels: Channels) {
    var isFollowing by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(channels.Imagess),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(8.dp)) // Rounded image for polish
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = channels.channel_name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = channels.channel_details,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { isFollowing = !isFollowing },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowing) Color.Gray else colorResource(id = R.color.light_green)
            ),
            modifier = Modifier
                .padding(8.dp)
                .height(38.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = if (isFollowing) "Following" else "Follow",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

data class Channels(
    val Imagess: Int,
    val channel_name: String,
    val channel_details: String
)

@Preview(showSystemUi = true)
@Composable
fun PreviewChannelItem() {
    ChannelItemDesign(
        channels = Channels(
            Imagess = R.drawable.meta,
            channel_name = "Meta",
            channel_details = "Discover the world"
        )
    )
}
