package com.vishu.assignment.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vishu.assignment.R
import com.vishu.assignment.components.IconComponentDrawable
import com.vishu.assignment.components.SpacerHeight
import com.vishu.assignment.components.SpacerWidth

@Composable
fun MainScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bluebank))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header()
            SpacerHeight(24.dp)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Cards(modifier = Modifier)
                    items(navController)
                }

            }
        }

    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp, start = 24.dp, end = 10.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        IconComponentDrawable(icon = R.drawable.profile, size = 50.dp)
        SpacerWidth(5.dp)
        Text(
            text = "Hi, Push Puttichai", fontSize = 16.sp, color = Color.White, modifier = Modifier
                .padding(start = 18.dp)
                .align(Alignment.CenterVertically)
        )
        SpacerWidth(107.dp)
        IconComponentDrawable(
            icon = R.drawable.notification,
            size = 26.dp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun Cards(
    modifier: Modifier = Modifier.padding(top = 14.dp, start = 24.dp, end = 24.dp)
) {
    Image(
        painter = painterResource(id = R.drawable.cards),
        contentDescription = "card",
        contentScale = ContentScale.FillWidth,
    )
}


@Composable
fun items(
    navController: NavHostController
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(15.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(top = 8.dp)
    ) {
        items(9) { index ->
            when (index) {
                0 -> FeatureButton(
                    "Account and Card",
                    R.drawable.account
                ) { /* Handle click */ }

                1 -> FeatureButton(
                    "Transfer",
                    R.drawable.transfer
                ) { navController.navigate("screen_transcations") }

                2 -> FeatureButton(
                    "Withdraw",
                    R.drawable.creditcard
                ) { /* Handle click */ }

                3 -> FeatureButton(
                    "Mobile prepaid",
                    R.drawable.mobileprepaid
                ) { /* Handle click */ }

                4 -> FeatureButton(
                    "Pay\nthe bill",
                    R.drawable.paybill
                ) { /* Handle click */ }

                5 -> FeatureButton(
                    "Save\nonline",
                    R.drawable.saveonline
                ) { /* Handle click */ }

                6 -> FeatureButton("Credit\ncard", R.drawable.creditcard) { /* Handle click */ }
                7 -> FeatureButton(
                    "Transaction report",
                    R.drawable.transcationreport
                ) { navController.navigate("payment_history") }

                8 -> FeatureButton(
                    "Beneficiary",
                    R.drawable.beneficiary
                ) { /* Handle click */ }
            }
        }
    }
}

@Composable
fun FeatureButton(text: String, icon: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(top = 10.dp, end = 20.dp, start = 20.dp, bottom = 10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(28.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = text,
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp
            )
        }
    }
}

