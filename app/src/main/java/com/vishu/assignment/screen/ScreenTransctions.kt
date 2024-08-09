package com.vishu.assignment.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vishu.assignment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmScreen(navController: NavController) {
    StatusBarColor()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Confirm", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("main") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.path),
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                scrollBehavior = null // Flat without elevation
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(y = (-50).dp) // Adjust this value to move the button up
            ) {
                Button(
                    onClick = { /* Handle Confirm */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B30CC))
                ) {
                    Text("Confirm", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(16.dp)
                    .fillMaxWidth()
                    .padding(bottom = 80.dp)
            ) {
                Text(
                    text = "Confirm transaction information",
                    style = MaterialTheme.typography.titleMedium, fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                ConfirmFieldWithLabel(label = "From", value = "**** **** 6789")
                Spacer(modifier = Modifier.height(16.dp))
                ConfirmFieldWithLabel(label = "To", value = "Amanda")
                Spacer(modifier = Modifier.height(16.dp))
                ConfirmFieldWithLabel(label = "Card number", value = "0123456789")
                Spacer(modifier = Modifier.height(16.dp))
                ConfirmFieldWithLabel(label = "Transaction fee", value = "10$")
                Spacer(modifier = Modifier.height(16.dp))
                ConfirmFieldWithLabel(label = "Content", value = "From Jimy")
                Spacer(modifier = Modifier.height(16.dp))
                ConfirmFieldWithLabel(label = "Amount", value = "$1000")
                Spacer(modifier = Modifier.height(16.dp))
                ConfirmFieldWithLabel(label = "Transaction fee", value = "10$")
                Spacer(modifier = Modifier.height(16.dp))
                ConfirmFieldWithLabel(label = "Content", value = "From Jimy")
                Spacer(modifier = Modifier.height(16.dp))
                ConfirmFieldWithLabel(label = "Amount", value = "$1000")

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    ConfirmFieldWithLabel(
                        label = "Get OTP to verify transaction",
                        value = "6789",
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { /* Handle Get OTP */ },
                        modifier = Modifier
                            .height(56.dp)
                            .align(Alignment.CenterVertically)
                            .background(Color(0xFF3B30CC), shape = RoundedCornerShape(25.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B30CC))
                    ) {
                        Text("Get OTP", color = Color.White, fontSize = 16.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun ConfirmFieldWithLabel(
    label: String,
    value: String,
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp),
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            enabled = true,
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)

        )
    }
}


@Composable
private fun StatusBarColor() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = true // Force dark icons
    val statusBarColor = colorResource(id = R.color.white)

    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = useDarkIcons
        )
    }
}
