package com.example.whatsapp.presentation.callscreen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Preview(showSystemUi = true)
@Composable
fun FavouriteSection() {
    val sampleFavouriteContacts = listOf(
        FavouriteContact(image = R.drawable.salman_khan, name = "Salman Khan"),
        FavouriteContact(image = R.drawable.sharukh_khan, name = "Sharukh Khan"),
        FavouriteContact(image = R.drawable.ajay_devgn, name = "Ajay Devgn"),
        FavouriteContact(image = R.drawable.sharadha_kapoor, name = "Shraddha Kapoor"),
        FavouriteContact(image = R.drawable.akshay_kumar, name = "Akshay Kumar"),
        FavouriteContact(image = R.drawable.bhuvan_bam, name = "Bhuvan Bam")
    )

    Column(modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)) {
        Text(
            text = "Favourites",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            sampleFavouriteContacts.forEach { contact ->
                FavouriteItem(contact) // ✅ using your separate FavouriteItem file
            }
        }
    }
}

data class FavouriteContact(
    val image: Int,
    val name: String
)
