package com.vishu.assignment


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vishu.assignment.screen.ConfirmScreen
import com.vishu.assignment.screen.MainScreen
import com.vishu.assignment.screen.ScreenHistory





@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("payment_history") { ScreenHistory(navController) }
        composable("screen_transcations") { ConfirmScreen(navController) }
    }
}
