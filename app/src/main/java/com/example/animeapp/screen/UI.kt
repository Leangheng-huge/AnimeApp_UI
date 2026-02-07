package com.example.animeapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class Anime(
    val title: String,
    val genre: String,
    val rating: Float,
    val gradientColors: List<Color>,
    val imageUrl: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val animeList = listOf(
        Anime(
            "One Piece",
            "Adventure",
            4.8f,
            listOf(Color(0xFFFF6B6B), Color(0xFFFF8E53)),
            "https://i.pinimg.com/736x/c9/87/a2/c987a28ac0b72afc74b1984dd7717c2a.jpg"
        ),
        Anime(
            "Naruto",
            "Action",
            4.7f,
            listOf(Color(0xFFFFD93D), Color(0xFFFFB800)),
            "https://i.pinimg.com/1200x/3a/8c/63/3a8c63737ae2d94f9d4f09f477e3df34.jpg"
        ),
        Anime(
            "Bleach",
            "Supernatural",
            4.5f,
            listOf(Color(0xFF6C5CE7), Color(0xFF9B59B6)),
            "https://i.pinimg.com/736x/da/95/d9/da95d96ae72940819266b3b1d2f86c72.jpg"
        ),
        Anime(
            "Cowboy Bebop",
            "Sci-Fi",
            4.9f,
            listOf(Color(0xFF00B4DB), Color(0xFF0083B0)),
            "https://i.pinimg.com/1200x/d1/96/9d/d1969d80f15f6d890ad6613551e2f7c3.jpg"
        ),
        Anime(
            "Detective Conan",
            "Mystery",
            4.6f,
            listOf(Color(0xFF4E54C8), Color(0xFF8F94FB)),
            "https://i.pinimg.com/736x/bc/45/c0/bc45c0fe977abc889067b7360c14f89b.jpg"
        ),
        Anime(
            "Dragon Ball Z",
            "Action",
            4.8f,
            listOf(Color(0xFFFF6B35), Color(0xFFF7931E)),
            "https://i.pinimg.com/736x/f1/63/60/f16360166bb294131a504d61503673ed.jpg"
        ),
        Anime(
            "My Hero Academia",
            "Superhero",
            4.7f,
            listOf(Color(0xFF11998E), Color(0xFF38EF7D)),
            "https://i.pinimg.com/736x/94/ea/f3/94eaf36ebaef4a16cc0931b1dcdf2f27.jpg"
        ),
        Anime(
            "Black Clover",
            "Fantasy",
            4.4f,
            listOf(Color(0xFF2C3E50), Color(0xFF4CA1AF)),
            "https://i.pinimg.com/736x/1a/3c/9b/1a3c9bcf1c288245bd90b2910555354f.jpg"
        ),
        Anime(
            "Mobile Suit Gundam",
            "Mecha",
            4.6f,
            listOf(Color(0xFFDA4453), Color(0xFF89216B)),
            "https://i.pinimg.com/1200x/1a/d6/29/1ad62926d6ee2b76080f2cf07d7e2ddb.jpg"
        )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Anime Collection",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0A0E27)
                )
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0A0E27),
                            Color(0xFF151930),
                            Color(0xFF1A1F3A)
                        )
                    )
                ),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            item {
                Column {
                    Text(
                        text = "Featured",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFE8E9ED),
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        items(animeList.take(5)) { anime ->
                            FeaturedAnimeCard(anime)
                        }
                    }
                }
            }

            item {
                Text(
                    text = "All Anime",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFE8E9ED),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            items(animeList) { anime ->
                AnimeListItem(anime)
            }
        }
    }
}

@Composable
fun FeaturedAnimeCard(anime: Anime) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(220.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            AsyncImage(
                model = anime.imageUrl,
                contentDescription = anime.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                anime.gradientColors[0].copy(alpha = 0.7f),
                                anime.gradientColors[1].copy(alpha = 0.9f)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = anime.rating.toString(),
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column {
                    Text(
                        text = anime.title,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 20.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = anime.genre,
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun AnimeListItem(anime: Anime) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E2538)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Card(
                    modifier = Modifier.size(60.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    AsyncImage(
                        model = anime.imageUrl,
                        contentDescription = anime.title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = anime.title,
                        color = Color(0xFFE8E9ED),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = anime.genre,
                        color = Color(0xFFB0B3C1),
                        fontSize = 13.sp
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = anime.rating.toString(),
                    color = Color(0xFFE8E9ED),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    MaterialTheme {
        HomeScreen()
    }
}