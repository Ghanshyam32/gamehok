package com.jivahealth.gamehok

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jivahealth.gamehok.ui.theme.GameHokTheme

class TournamentPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameHokTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TournamentDetailsScreen()
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun TournamentDetailsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        // Header Section
        Box {
            Image(
                painter = painterResource(id = R.drawable.banner_image), // Replace with actual image
                contentDescription = "Tournament Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Registration Closes in 2d 15h 10m",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(
                            Color.Black.copy(alpha = 0.7f),
                            shape = RoundedCornerShape(16.dp)
                        ) // Apply the rounded corners to the background
                        .padding(horizontal = 8.dp, vertical = 4.dp) // Padding around the text
                )

                Text(
                    text = "670/800",
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .background(
                            Color.Black.copy(alpha = 0.7f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tournament Title Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "PUBG Tournament",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "By Red Bull",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Tags(text = "BGMI")
                    Spacer(modifier = Modifier.width(8.dp))
                    Tags(text = "Entry-10 \uD83E\uDE99")
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ic_redbull_logo), // Replace with actual logo
                contentDescription = "Red Bull Logo",
                modifier = Modifier.size(48.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tabs Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Overview",
                color = Color.Green,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Players",
                color = Color.Gray,
                fontSize = 16.sp
            )
            Text(
                text = "Rules",
                color = Color.Gray,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            DetailsRow(icon = R.drawable.team_icon, title = "Team Size", value = "Solo")
            DetailsRow(
                icon = R.drawable.format_icon,
                title = "Format",
                value = "Single Elimination"
            )
            DetailsRow(
                icon = R.drawable.calendar_icon,
                title = "Tournament Starts",
                value = "Tue 24th Jan 2024, 01:00 PM"
            )
            DetailsRow(
                icon = R.drawable.clock_icon,
                title = "Check-In",
                value = "10 mins before the match starts"
            )

            Spacer(modifier = Modifier.height(10.dp))


            Image(
                painter = painterResource(id = R.drawable.prize_list),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .padding(bottom = 16.dp)
            )
            RoundsAndSchedule()
            OrganiserDetailsCard()
            Text(
                text = "Compete in Battles",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )
            HorizontalScrollableCardss()

            PreviewJoinTournamentButton()
        }
    }
}

    @Composable
    fun Tags(text: String) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .background(Color(0xFF002E14), shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }

    @Composable
    fun DetailsRow(icon: Int, title: String, value: String) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = value,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }

    @Composable
    fun RoundsAndSchedule() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Rounds and Schedule",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            ScheduleItem()
            ScheduleItem()
            ScheduleItem()

            Text(
                text = "How to Join a Match",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
                    .padding(top = 5.dp)
            )

            val guidelines = listOf(
                "Have your game open already and on the latest version",
                "Once the match is configured you will receive an invite in-game to join the lobby.",
                "Join the match and wait for the game to start.",
                "When eliminated return to the match room page to be ready to join the next map in the round."
            )

            Column {
                guidelines.forEach { guideline ->
                    Row(modifier = Modifier.padding(bottom = 8.dp)) {
                        Text(
                            text = "\u2022", // Bullet point
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = guideline,
                            fontSize = 14.sp,
                            color = Color(0xFFBCBCBC)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun ScheduleItem() {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Qualifiers (Round 1)",
                        fontSize = 13.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Top 4 to next round",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "Single Elimination",
                        fontSize = 12.sp,
                        color = Color.White, // Purple color
                        modifier = Modifier
                            .background(Color(0xFF311B92), shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                    Text(
                        text = "3rd Aug, 10:00 pm",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

            }
            Divider(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .background(Color(0xFF3C4B43))
            )
        }

    }

    @Composable
    fun OrganiserDetailsCard() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    Color(0xFF0A110E),
                    shape = RoundedCornerShape(16.dp)
                ) // Background with rounded corners
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Title Section
                Text(
                    text = "Organiser’s Details and contact",
                    color = Color(0xFFB0B0B0),
                    fontSize = 17.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon),
                        contentDescription = "Organiser Logo",
                        modifier = Modifier
                            .size(40.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    // Organiser Name and Description
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Gamehok Esports",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }

                    // Follow Button
                    Button(
                        onClick = { /* Handle Follow */ },
                        colors = ButtonDefaults.buttonColors(Color(0xFF002E14)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Follow", color = Color.White, fontSize = 14.sp)
                    }
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Contact Information
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "This is the in-house organiser of this platform you can follow our page on this platform for regular updates",
                        color = Color(0xFFB0B0B0),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                            .height(20.dp)
                            .fillMaxWidth()
                    ) {
                        ContactRow(icon = Icons.Default.Person, content = "9890987754")
                        ContactRow(icon = Icons.Default.Email, content = "Support@gamehok.com")
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    ContactRow(icon = Icons.Default.Phone, content = "9890987754")
                }
            }
        }
    }

    @Composable
    fun ContactRow(icon: ImageVector, content: String) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFFB0B0B0),
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = content,
                color = Color(0xFFB0B0B0),
                fontSize = 14.sp
            )
        }
    }

    @Composable
    fun PreviewOrganiserDetailsCard() {
        OrganiserDetailsCard()
    }

    @Composable
    fun HorizontalScrollableCardss() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(3) {
                TournamentCard()
            }
        }
    }

    @Composable
    fun TournamentCardd() {
        val context = LocalContext.current

        Box(
            modifier = Modifier
                .width(300.dp)
                .background(
                    color = Color(0xFF1B5E20),
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // Create and launch the intent directly
                        val intent = Intent(context, TournamentPage::class.java)
                        context.startActivity(intent)
                    }
                    .padding(8.dp)
            ) {
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
                        painter = painterResource(id = R.drawable.ic_redbull_logo),
                        contentDescription = "RedBull Logo",
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    )
                }

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

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Tag(text = "BGMI")
                        Tag(text = "Solo")
                        Tag(text = "Entry - 10 🪙")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_clockk),
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
                                painter = painterResource(id = R.drawable.trophy),
                                contentDescription = "Trophy Icon",
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "Prize Pool - 1000 🪙",
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
    fun JoinTournamentButton(onClick: () -> Unit) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(Color(0xFF00C853)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(48.dp)
        ) {
            Text(
                text = "JOIN TOURNAMENT",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun PreviewJoinTournamentButton() {
        JoinTournamentButton(onClick = {})
    }
