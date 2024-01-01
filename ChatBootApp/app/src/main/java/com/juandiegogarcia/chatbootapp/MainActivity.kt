package com.juandiegogarcia.chatbootapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juandiegogarcia.chatbootapp.screen.ChatRoomListScreen
import com.juandiegogarcia.chatbootapp.screen.ChatScreen
import com.juandiegogarcia.chatbootapp.screen.LoginScreen
import com.juandiegogarcia.chatbootapp.screen.Screen
import com.juandiegogarcia.chatbootapp.screen.SignUpScreen
import com.juandiegogarcia.chatbootapp.ui.theme.ChatBootAppTheme
import com.juandiegogarcia.chatbootapp.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val authViewModel : AuthViewModel = viewModel()
            ChatBootAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph(navController = navController, authViewModel = authViewModel)
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignupScreen.route
    ) {
        composable(Screen.SignupScreen.route) {
            SignUpScreen(
                authViewModel = authViewModel,
                onNavigateToLogin = { navController.navigate(Screen.LoginScreen.route) }
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                authViewModel = authViewModel,
                onNavigateToSignUP = { navController.navigate(Screen.SignupScreen.route) }
            ){
                navController.navigate(Screen.ChatRoomsScreen.route)
            }
        }
        composable(Screen.ChatRoomsScreen.route) {
            ChatRoomListScreen {
                navController.navigate("${Screen.ChatScreen.route}/${it}")
            }
        }
        composable("${Screen.ChatScreen.route}/{roomId}") {
            val roomId: String = it
                .arguments?.getString("roomId") ?: ""
            ChatScreen(roomId = roomId)
        }

    }
}