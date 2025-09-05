package com.example.whatsapp.presentation.callscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

// Sample preview data
val sampleCall = Call(
    image = R.drawable.salman_khan,
    name = "Salman Khan",
    time = "10:45 AM",
    isMissed = true
)

@Preview(showSystemUi = true)
@Composable
fun CallItemPreview() {
    CallItemDesign(call = sampleCall)
}

@Composable
fun CallItemDesign(call: Call) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image
        Image(
            painter = painterResource(call.image),
            contentDescription = call.name,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Name + Call Info
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = call.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_call_missed_24),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = if (call.isMissed) Color.Red else colorResource(R.color.light_green)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = call.time,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Call Button
        IconButton(
            onClick = { /* Handle call click */ },
            modifier = Modifier
        ) {
            Icon(
                painter = painterResource(R.drawable.telephone),
                contentDescription = "Call",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
