package com.example.whatsapp.presentation.callscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

@Preview(showSystemUi = true)
@Composable
fun CallScreen() {
    val dummyCalls = listOf(
        Call(R.drawable.salman_khan, "Salman Khan", "Yesterday, 10:45 AM", true),
        Call(R.drawable.sharukh_khan, "Sharukh Khan", "Today, 9:30 AM", false),
        Call(R.drawable.ajay_devgn, "Ajay Devgn", "Yesterday, 8:15 AM", true),
        Call(R.drawable.sharadha_kapoor, "Shraddha Kapoor", "August 20, 7:45 AM", false),
        Call(R.drawable.akshay_kumar, "Akshay Kumar", "Yesterday, 6:30 AM", true),
        Call(R.drawable.bhuvan_bam, "Bhuvan Bam", "Today, 5:15 AM", false)
    )

    var isSearching by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
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
                            text = "Calls",
                            fontSize = 24.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        )

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
                                    text = { Text("Clear Call Logs") },
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
        },
        bottomBar = { BottomNavigation() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO */ },
                containerColor = colorResource(R.color.light_green),
                modifier = Modifier.size(65.dp),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(R.drawable.add_call),
                    contentDescription = "Add new Call",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    ) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {
            Spacer(modifier = Modifier.height(16.dp))

            // If you have a separate FavouriteSection composable, call it here
             FavouriteSection()

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {/* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.light_green)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Start a new Call",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Recent Calls",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyColumn {
                items(dummyCalls) { call ->
                    CallItemDesign(call)
                }
            }
        }
    }
}
