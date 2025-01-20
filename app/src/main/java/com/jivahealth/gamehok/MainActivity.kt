package com.jivahealth.gamehok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jivahealth.gamehok.ui.theme.GameHokTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameHokTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameHokUI()
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun GameHokUI() {
    // Top section with coins and tickets
    Column(modifier = Modifier.background(Color.Black)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_avatar),
                contentDescription = "Avatar",
                modifier = Modifier.size(40.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                CoinAndTicketDisplay("245", R.drawable.ic_ticket)
                Spacer(modifier = Modifier.width(16.dp))
                CoinAndTicketDisplay("2456", R.drawable.ic_coin)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
        ) {


            // Banner section with horizontal pager
//        val pagerState = rememberPagerState(initialPage = 0)
            val pagerState = rememberPagerState(pageCount = { 3 }) // Pass the pageCount here.

            Column(modifier = Modifier.fillMaxWidth()) {
                // Horizontal Pager
                HorizontalPager(
                    state = pagerState, // Use the pagerState initialized with pageCount.
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    BannerImage(page) // Render content for each page.
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Dots Indicator
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { index -> // Use pagerState.pageCount here.
                        val isSelected = pagerState.currentPage == index
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .size(if (isSelected) 12.dp else 8.dp)
                                .background(
                                    color = if (isSelected) Color(0xFFFAA100) else Color(0xFFCCCCCC),
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }
            }



            Spacer(modifier = Modifier.height(16.dp))

            // Tournament section
            // Tournament section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Play Tournament by Games",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "View All",
                    fontSize = 16.sp,
                    color = Color(0xFF00FF00), // Green color
                    modifier = Modifier.padding(end = 4.dp)
                )
            }


            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val games = listOf(
                    "PUBG" to R.drawable.ic_pubg,
                    "Call of Duty" to R.drawable.ic_cod,
                    "Counter Strike" to R.drawable.ic_cs
                )
                games.forEach { (name, icon) ->
                    GameCard(name, icon)
                }
            }
            Spacer(modifier = Modifier.height(5.dp))

            // Tournament section
            // Tournament section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Compete in Battles",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "View All",
                    fontSize = 16.sp,
                    color = Color(0xFF00FF00), // Green color
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))

            HorizontalScrollableCards()
            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Learn from the best to be the best",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))

            val pagerState2 = rememberPagerState {
                4
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                // Horizontal Pager
                HorizontalPager(
                    state = pagerState2, // Use the pagerState initialized with pageCount.
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    BannerImage2(page) // Render content for each page.
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Dots Indicator
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState2.pageCount) { index -> // Use pagerState.pageCount here.
                        val isSelected = pagerState2.currentPage == index
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .size(if (isSelected) 12.dp else 8.dp)
                                .background(
                                    color = if (isSelected) Color(0xFFFAA100) else Color(0xFFCCCCCC),
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "People to follow",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "View More",
                    fontSize = 16.sp,
                    color = Color(0xFF00FF00), // Green color
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
            PeopleToFollowSection()
        }
    }


}

@Composable
fun CoinAndTicketDisplay(value: String, iconRes: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = value,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(end = 4.dp)
        )
        Image(
            painter = painterResource(id = iconRes),
            modifier = Modifier
                .height(20.dp)
                .width(20.dp),
            contentDescription = ""
        )
    }
}

@Composable
fun BannerImage(page: Int) {
    val bannerImages = listOf(
        R.drawable.banner1,
        R.drawable.img_1,
        R.drawable.banner3
    )

    Image(
        painter = painterResource(id = bannerImages[page]),
        contentDescription = "Banner $page",
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
    )
}

@Composable
fun BannerImage2(page: Int) {
    val bannerImages = listOf(
        R.drawable.esports,
        R.drawable.img_1,
        R.drawable.esports3,
        R.drawable.img_1,
    )

    Image(
        painter = painterResource(id = bannerImages[page]),
        contentDescription = "Banner $page",
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    )
}

@Composable
fun PeopleToFollowSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        // List of People to Follow
        val users = listOf(
            Pair("Legend Gamer", R.drawable.avatar1), // Replace with actual drawable resources
            Pair("Legend Gamer", R.drawable.avatar2),
            Pair("Legend Gamer", R.drawable.avatar3)
        )

        users.forEach { (name, avatarRes) ->
            PersonCard(name = name, avatarRes = avatarRes)
            Spacer(modifier = Modifier.height(16.dp)) // Space between cards
        }
    }
}

@Composable
fun PersonCard(name: String, avatarRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar
        Image(
            painter = painterResource(id = avatarRes),
            contentDescription = name,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.Gray) // Placeholder for avatar
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Name
        Text(
            text = name,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.weight(1f) // Take remaining space
        )

        // Follow Button
        Button(
            onClick = { },
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .height(36.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00361A) // Dark green
            )
        ) {
            Text(text = "Follow", fontSize = 14.sp, color = Color.White)
        }
    }
}

@Composable
fun PreviewPeopleToFollow() {
    PeopleToFollowSection()
}

@Composable
fun GameCard(gameName: String, drawableRes: Int) {
    Column(
        modifier = Modifier
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = gameName,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = gameName,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun HorizontalScrollableCards() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(3) { // Adjust the repeat count as needed to display more cards
            TournamentCard()
        }
    }
}

@Composable
fun TournamentCard() {
    Box(
        modifier = Modifier
            .width(300.dp)
            .background(
                color = Color(0xFF1B5E20), // Updated background
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp)) // Ensures the card is properly clipped
            .padding(8.dp)
    ) {
        Column {
            // Image Section with Registration Open and Player Count
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pubg_banner), // Replace with your drawable resource
                    contentDescription = "Tournament Background Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Registration Open",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .background(
                                color = Color(0xAA000000),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                    Text(
                        text = "670/800",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .background(
                                color = Color(0xAA000000),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_redbull_logo), // Replace with actual logo
                    contentDescription = "RedBull Logo",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                )
            }

            // Text Section
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "PUBG Tournament",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "By Red Bull",
                    fontSize = 12.sp,
                    color = Color(0xFFCCCCCC)
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Tags Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Tag(text = "BGMI")
                    Tag(text = "Solo")
                    Tag(text = "Entry - 10 🪙") // Added coins icon
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Timing and Prize Pool Section
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clockk), // Clock icon
                            contentDescription = "Clock Icon",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Starts 3rd Aug at 10:00 pm",
                            fontSize = 12.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.trophy), // Trophy icon
                            contentDescription = "Trophy Icon",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Prize Pool - 1000 🪙", // Added coins icon
                            fontSize = 12.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun learn() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Compete in Battles",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "View All",
            fontSize = 16.sp,
            color = Color(0xFF00FF00), // Green color
            modifier = Modifier.padding(end = 4.dp)
        )
    }
}

@Composable
fun Tag(text: String) {
    Text(
        text = text,
        fontSize = 12.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(
                color = Color(0xAA000000),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}
