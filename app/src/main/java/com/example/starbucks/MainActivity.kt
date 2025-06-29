package com.example.starbucks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starbucks.ui.theme.StarbucksTheme

// Warna khas Starbucks (bisa disesuaikan)
val StarbucksGreen = Color(0xFF006241)
val DarkGreen = Color(0xFF004C33)
val Cream = Color(0xFFF3F1E7)
val WarmGray = Color(0xFF7B7B7B)

// Data class sederhana untuk item menu
data class Coffee(
    val name: String,
    val description: String,
    val price: String,
    val icon: ImageVector
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Daftar menu kopi (data pseudo)
        val coffeeMenu = listOf(
            Coffee("Caffè Latte", "Espresso kaya rasa dengan susu steam", "Rp 48.000", Icons.Default.Coffee),
            Coffee("Caramel Macchiato", "Susu steam dengan sirup vanila dan espresso", "Rp 59.000", Icons.Default.LocalCafe),
            Coffee("Java Chip Frappuccino", "Kopi, susu, saus moka, dan butiran cokelat", "Rp 62.000", Icons.Default.Icecream),
            Coffee("Asian Dolce Latte", "Espresso, susu, dengan saus dolce spesial", "Rp 55.000", Icons.Default.CoffeeMaker),
            Coffee("Cold Brew", "Kopi yang diseduh perlahan selama 20 jam", "Rp 45.000", Icons.Default.Coffee),
            Coffee("Green Tea Latte", "Teh hijau murni dengan susu steam", "Rp 55.000", Icons.Default.EmojiFoodBeverage)
        )

        setContent {
          StarbucksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StarbucksHomeScreen(coffeeMenu)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarbucksHomeScreen(menu: List<Coffee>) {
    var selectedItem by remember { mutableStateOf(0) }
    val navItems = listOf("Home", "Menu", "Rewards", "Profile")
    val navIcons = listOf(Icons.Filled.Home, Icons.Filled.Menu, Icons.Filled.Star, Icons.Filled.Person)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // --- PSEUDO LOGO ---
                    Text(
                        "STARBUCKS",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    IconButton(onClick = { /* TODO: Aksi untuk notifikasi */ }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notifikasi", tint = Color.White)
                    }
                    IconButton(onClick = { /* TODO: Aksi untuk menu lainnya */ }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Lainnya", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = StarbucksGreen
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(navIcons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = StarbucksGreen,
                            selectedTextColor = StarbucksGreen,
                            indicatorColor = Cream,
                            unselectedIconColor = WarmGray,
                            unselectedTextColor = WarmGray
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Cream)
        ) {
            // Header
            item {
                WelcomeHeader()
            }

            // Kartu Promosi
            item {
                PromoCard()
            }

            // Judul
            item {
                Text(
                    text = "Menu Favorit Untukmu",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }

            // Daftar Menu
            items(menu) { coffee ->
                CoffeeMenuItem(coffee = coffee)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun WelcomeHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkGreen)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = "Selamat Pagi!",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Menikmati kopi di hari yang cerah.",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White.copy(alpha = 0.8f)
        )
    }
}


@Composable
fun PromoCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // --- PSEUDO GAMBAR PROMO ---
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(StarbucksGreen),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "Promo Icon",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Tumbler Day!",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Bawa Tumbler-mu dan dapatkan diskon 50% untuk minuman apa saja.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = WarmGray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* TODO: Aksi lihat promo */ },
                    colors = ButtonDefaults.buttonColors(containerColor = StarbucksGreen)
                ) {
                    Text("Lihat Promo")
                }
            }
        }
    }
}


@Composable
fun CoffeeMenuItem(coffee: Coffee) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // --- ICON UNTUK SETIAP ITEM MENU ---
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Cream),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = coffee.icon,
                    contentDescription = coffee.name,
                    tint = StarbucksGreen,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = coffee.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = coffee.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = WarmGray
                )
                Text(
                    text = coffee.price,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = { /* TODO: Aksi tambah ke keranjang */ },
                modifier = Modifier.background(StarbucksGreen, CircleShape)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Tambah ke Keranjang",
                    tint = Color.White
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val previewMenu = listOf(
        Coffee("Caffè Latte", "Espresso kaya rasa dengan susu steam", "Rp 48.000", Icons.Default.Favorite),
        Coffee("Caramel Macchiato", "Susu steam dengan sirup vanila dan espresso", "Rp 59.000", Icons.Default.AddCircle)
    )
    StarbucksTheme {
        StarbucksHomeScreen(menu = previewMenu)
    }
}