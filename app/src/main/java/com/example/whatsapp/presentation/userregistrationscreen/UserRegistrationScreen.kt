package com.example.whatsapp.presentation.userregistrationscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Preview(showSystemUi = true)
@Composable
fun UserRegistrationScreen() {
    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("India") }
    var countryCode by remember { mutableStateOf("+91") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Title
        Text(
            text = "Enter your Phone number",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.dark_green)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Info text
        Row {
            Text(text = "WhatsApp will need to verify your phone number")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "What's", color = colorResource(R.color.dark_green))
        }

        Row {
            Text(text = "my number", color = colorResource(R.color.dark_green))
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "?")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Country Dropdown
        TextButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = selectedCountry,
                    fontSize = 16.sp,
                    color = Color.Black,
                   // modifier = Modifier.weight(1f),

                )
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "Drop Down Country",
                    tint = colorResource(R.color.light_green)
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 106.dp),
            thickness = 2.dp,
            color = colorResource(R.color.light_green)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf("India", "Japan", "USA", "China", "Nepal").forEach { country ->
                DropdownMenuItem(
                    text = { Text(text = country) },
                    onClick = {
                        selectedCountry = country
                        expanded = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Phone Number Input
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = countryCode,
                onValueChange = { countryCode = it },
                modifier = Modifier.width(80.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = colorResource(R.color.light_green),
                    unfocusedIndicatorColor = colorResource(R.color.light_green)
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                placeholder = { Text(text = "Phone Number") },
                singleLine = true,
                modifier = Modifier.weight(1f),
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = colorResource(R.color.light_green),
                    unfocusedIndicatorColor = colorResource(R.color.light_green)
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Carrier Charges may apply",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(26.dp))

        Button(
            onClick = { /* TODO */ },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.dark_green))
        ) {
            Text(text = "Next", fontSize = 16.sp, color = Color.White)
        }
    }
}
