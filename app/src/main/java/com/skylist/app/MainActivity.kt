package com.skylist.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SkyListApp() }
    }
}

val SkyBlue = Color(0xFF0288D1)
val SkyBg = Color(0xFFE1F5FE)

@Composable
fun SkyListApp() {
    MaterialTheme(colorScheme = lightColorScheme(primary = SkyBlue, background = SkyBg)) {
        Scaffold(
            topBar = {
                SmallTopAppBar(
                    title = { Text("SkyList - Classifieds") },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = SkyBlue,
                        titleContentColor = Color.White
                    )
                )
            },
            containerColor = SkyBg
        ) { pad ->
            val categories = listOf(
                "Properties" to listOf("Flats", "Houses", "PG", "Land", "Commercial"),
                "Electronics" to listOf("Mobiles", "Laptops", "Cameras", "Gaming"),
                "General" to listOf("Books", "Fashion", "Sports"),
                "Furniture" to listOf("Sofa", "Beds", "Tables", "Decor"),
                "Vehicles" to listOf("Cars", "Bikes", "Scooters", "Commercial")
            )
            LazyColumn(
                modifier = Modifier.padding(pad).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categories) { (title, subs) ->
                    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                        Column(Modifier.padding(16.dp)) {
                            Text(title, style = MaterialTheme.typography.titleMedium, color = SkyBlue)
                            Spacer(Modifier.height(8.dp))
                            Text(subs.joinToString(" • "))
                        }
                    }
                }
                item {
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = SkyBlue)
                    ) {
                        Text("Post Ad (8 images max) - Coming Soon")
                    }
                }
            }
        }
    }
}
