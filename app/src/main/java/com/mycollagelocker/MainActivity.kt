package com.mycollagelocker

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import guard.GuardDashboardScreen
    import login.LoginScreen
    import navigation.Routes
    import student.StudentDashboardScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContent {
           val navController = rememberNavController()
           NavHost(
               navController = navController,
               startDestination = Routes.LOGIN
           ) {
              composable(Routes.LOGIN) { LoginScreen(navController) }
               composable(Routes.STUDENT) { StudentDashboardScreen() }
               composable(Routes.GUARD) { GuardDashboardScreen() }
               composable(Routes.CREATE_VIRTUAL_ID) {  }
               composable(Routes.PREVIEW_VIRTUAL_ID) {   }
           }
       }

    }
}








