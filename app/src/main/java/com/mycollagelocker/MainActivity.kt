package com.mycollagelocker

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import guard.GuardDashboardScreen
    import login.LoginScreen
    import navigation.Routes
    import student.StudentDashboardScreen
    import student.StudentIdMainScreen
    import student.StudentIdViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContent {
           val navController = rememberNavController()
           val studentVm: StudentIdViewModel = viewModel()

           NavHost(
               navController = navController,
               startDestination = Routes.LOGIN
           ) {
              composable(Routes.LOGIN) { LoginScreen(navController) }
               composable(Routes.STUDENT_DASH) { StudentDashboardScreen(navController, studentVm) }
               composable(Routes.STUDENT_ID) {
                   StudentIdMainScreen( navController, studentVm) }
               composable(Routes.GUARD) { GuardDashboardScreen() }

           }
       }
    }
}








