package com.vishu.assignment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class PaymentHistoryItem(
    val month: String,
    val status: String,
    val statusColor: Color,
    val company: String,
    val amount: String,
    val date: String


)


@Composable
fun PaymentHistoryList() {
    val paymentHistory = listOf(
        PaymentHistoryItem(
            "October",
            "Unsuccessfully",
            Color.Red,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "September",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "August",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "July",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "June",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50", "30/10/2019"
        ),
        PaymentHistoryItem(
            "October",
            "Unsuccessfully",
            Color.Red,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "September",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "August",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "July",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "June",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "October",
            "Unsuccessfully",
            Color.Red,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "September",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "August",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "July",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "June",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "October",
            "Unsuccessfully",
            Color.Red,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "September",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "August",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "July",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        ),
        PaymentHistoryItem(
            "June",
            "Successfully",
            Color.Blue,
            "Capi Telecom",
            "$50",
            "30/10/2019"
        )

    )

    LazyColumn() {
        items(paymentHistory.size) { index ->
            PaymentHistoryCard(paymentHistory[index])
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun PaymentHistoryCard(item: PaymentHistoryItem) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.3.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp) // Set height
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item.month, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = item.date, fontSize = 12.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Status Column
                Column {
                    Row {
                        Text(text = "Status ", fontSize = 12.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.width(22.dp))
                        Text(
                            text = item.status,
                            fontSize = 12.sp,
                            color = item.statusColor,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Column {
                    Row {
                        Text(text = "Amount ", fontSize = 12.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = item.amount,
                            fontSize = 12.sp,
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(0.dp))
            Row {
                Text(text = "Company ", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = item.company,
                    fontSize = 12.sp,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
