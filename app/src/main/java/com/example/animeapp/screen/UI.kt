package com.example.animeapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val rating: String,
    val gradientColors: List<Color>,
    val imageUrl: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var selectedAnime by remember { mutableStateOf<Anime?>(null) }

    val animeList = listOf(
        Anime(
            "One Piece",
            "Action, Adventure",
            "4.9",
            listOf(Color(0xFFFF6B6B), Color(0xFFFF8E53)),
            "https://i.pinimg.com/1200x/04/65/2b/04652b44ea7c1275d1022d98d59ecc97.jpg"
        ),
        Anime(
            "Naruto",
            "Action, Adventure",
            "4.8",
            listOf(Color(0xFFFFD93D), Color(0xFFFFB800)),
            "https://i.pinimg.com/1200x/46/8b/ac/468baccda1af6b7abc94e6740708c5a5.jpg"
        ),
        Anime(
            "Bleach",
            "Supernatural, Action",
            "4.6",
            listOf(Color(0xFF6C5CE7), Color(0xFF9B59B6)),
            "https://i.pinimg.com/736x/3e/e0/29/3ee0299589bf61871e2f838a48f4b965.jpg"
        ),
        Anime(
            "Cowboy Bebop",
            "Sci-Fi, Action",
            "4.9",
            listOf(Color(0xFF00B4DB), Color(0xFF0083B0)),
            "https://i.pinimg.com/736x/26/9d/23/269d23d850d79e75d455f3715f44144b.jpg"
        ),
        Anime(
            "Detective Conan",
            "Mystery, Comedy",
            "4.7",
            listOf(Color(0xFF4E54C8), Color(0xFF8F94FB)),
            "https://i.pinimg.com/736x/83/d7/57/83d75757809d2578459d80052e155003.jpg"
        ),
        Anime(
            "Dragon Ball Z",
            "Action, Fantasy",
            "4.8",
            listOf(Color(0xFFFF6B35), Color(0xFFF7931E)),
            "https://i.pinimg.com/1200x/35/15/d5/3515d548431c50d3d5055879f4df54b8.jpg"
        ),
        Anime(
            "My Hero Academia",
            "Superhero, Action",
            "4.7",
            listOf(Color(0xFF11998E), Color(0xFF38EF7D)),
            "https://i.pinimg.com/736x/94/ea/f3/94eaf36ebaef4a16cc0931b1dcdf2f27.jpg"
        ),
        Anime(
            "Black Clover",
            "Fantasy, Action",
            "4.5",
            listOf(Color(0xFF2C3E50), Color(0xFF4CA1AF)),
            "https://i.pinimg.com/736x/1a/3c/9b/1a3c9bcf1c288245bd90b2910555354f.jpg"
        ),
        Anime(
            "Mobile Suit Gundam",
            "Mecha, Sci-Fi",
            "4.6",
            listOf(Color(0xFFDA4453), Color(0xFF89216B)),
            "https://i.pinimg.com/1200x/1a/d6/29/1ad62926d6ee2b76080f2cf07d7e2ddb.jpg"
        ),
        Anime(
            "Jujutsu Kaisen",
            "Dark Fantasy, Action",
            "4.9",
            listOf(Color(0xFF8B5A9C), Color(0xFF5D3A6B)),
            "https://i.pinimg.com/736x/26/99/78/2699785bfb59f05a9ccbad8c837f6d5b.jpg"
        ),
        Anime(
            "Demon Slayer",
            "Dark Fantasy, Action",
            "4.9",
            listOf(Color(0xFFE63946), Color(0xFF8B1E3F)),
            "https://i.pinimg.com/736x/39/9b/83/399b83aa72375e3e8aad65b57656f646.jpg"
        ),
        Anime(
            "Attack on Titan",
            "Dark Fantasy, Action",
            "4.9",
            listOf(Color(0xFF3A5A40), Color(0xFF1B4332)),
            "https://i.pinimg.com/736x/24/01/a1/2401a164aa123b90b4ed3ad08e46e251.jpg"
        )
    )

    if (showDialog && selectedAnime != null) {
        AnimeAlertDialog(
            anime = selectedAnime!!,
            onDismissRequest = {
                showDialog = false
                selectedAnime = null
            }
        )
    }

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
                            FeaturedAnimeCard(
                                anime = anime,
                                onClick = {
                                    selectedAnime = anime
                                    showDialog = true
                                }
                            )
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
                AnimeListItem(
                    anime = anime,
                    onClick = {
                        selectedAnime = anime
                        showDialog = true
                    }
                )
            }
        }
    }
}

@Composable
fun FeaturedAnimeCard(
    anime: Anime,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(220.dp)
            .clickable { onClick() },
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
                        text = anime.rating,
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
fun AnimeListItem(
    anime: Anime,
    onClick: () -> Unit
) {
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
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.weight(1f)
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = anime.rating,
                            color = Color(0xFFE8E9ED),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5B6B94)
                ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Details",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun AnimeAlertDialog(
    anime: Anime,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(
                text = anime.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF0A0E27)
            )
        },
        text = {
            Column {
                // Add anime image in dialog
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        AsyncImage(
                            model = anime.imageUrl,
                            contentDescription = anime.title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        // Gradient overlay
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            anime.gradientColors[0].copy(alpha = 0.5f),
                                            anime.gradientColors[1].copy(alpha = 0.7f)
                                        )
                                    )
                                )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "This is a featured anime series with high ratings and great reviews.",
                    fontSize = 14.sp,
                    color = Color(0xFF2A3142)
                )
                Spacer(modifier = Modifier.height(8.dp))

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
                        text = "Rating: ${anime.rating}",
                        fontSize = 13.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Genre: ${anime.genre}",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = onDismissRequest,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(0xFF5B6B94)
                )
            ) {
                Text(
                    text = "Watch Now",
                    fontWeight = FontWeight.Medium
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismissRequest,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(0xFFC30010)
                )
            ) {
                Text(
                    text = "Close",
                    fontWeight = FontWeight.Medium
                )
            }
        },
        containerColor = Color.White,
        shape = RoundedCornerShape(16.dp)
    )
}

@Preview
@Composable
fun Preview() {
    MaterialTheme {
        HomeScreen()
    }
}