package com.example.whatsapp.presentation.updatescreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Preview(showSystemUi = true)
@Composable
fun TopBar() {
    var isSearching by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var showMenu by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            if (isSearching) {
                TextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search") },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                IconButton(onClick = {
                    isSearching = false
                    searchQuery = ""
                }) {
                    Icon(
                        painter = painterResource(R.drawable.cross),
                        contentDescription = "Close Search",
                        modifier = Modifier.size(22.dp)
                    )
                }
            } else {
                Text(
                    text = "Updates",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                IconButton(onClick = { /* Open Camera */ }) {
                    Icon(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = "Camera",
                        modifier = Modifier.size(24.dp)
                    )
                }

                IconButton(onClick = { isSearching = true }) {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Box {
                    IconButton(onClick = { showMenu = true }) {
                        Icon(
                            painter = painterResource(R.drawable.more),
                            contentDescription = "More Options",
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Status Privacy") },
                            onClick = { showMenu = false }
                        )
                        DropdownMenuItem(
                            text = { Text("Create Channel") },
                            onClick = { showMenu = false }
                        )
                        DropdownMenuItem(
                            text = { Text("Settings") },
                            onClick = { showMenu = false }
                        )
                    }
                }
            }
        }

        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
    }
}
