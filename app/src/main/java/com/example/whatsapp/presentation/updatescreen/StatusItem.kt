package com.example.whatsapp.presentation.updatescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Preview(showSystemUi = true)
@Composable
fun PreviewStatusItem() {
    StatusItem(
        statusData = StatusData(
            image = R.drawable.bhuvan_bam,
            name = "My Status",
            time = "Tap to add status update",
            isMyStatus = true
        )
    )
}

data class StatusData(
    val image: Int,
    val name: String,
    val time: String,
    val isMyStatus: Boolean = false // 👈 differentiate my status from others
)

@Composable
fun StatusItem(statusData: StatusData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(statusData.image),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop // 👈 fills circle properly
            )

            // 👇 Show "+" icon only for "My Status"
            if (statusData.isMyStatus) {
                Icon(
                    painter = painterResource(R.drawable.baseline_add_24),
                    contentDescription = "Add Status",
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = colorResource(R.color.light_green),
                            shape = RoundedCornerShape(50)
                        )
                        .padding(3.dp),
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = statusData.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = statusData.time,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
