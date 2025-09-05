package com.example.whatsapp.presentation.homescreen

/**
 * Data class representing a single chat item.
 * @param image Resource ID of profile image
 * @param name Contact name
 * @param message Last message content
 * @param time Time of the last message
 */
data class ChatListModel(
    val image: Int,
    val name: String,
    val message: String,
    val time: String
)
