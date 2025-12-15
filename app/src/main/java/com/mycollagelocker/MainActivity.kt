package com.mycollagelocker

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.platform.LocalContext
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import datastore.AppPreferenceManager
    import guard.GuardDashboardScreen
    import kotlinx.coroutines.runBlocking
    import login.LoginScreen
    import login.LoginViewModel
    import login.LoginViewModelFactory
    import navigation.Routes
    import student.StudentDashboardScreen
    import student.StudentIdMainScreen
    import student.StudentIdViewModel
    import student.StudentIdViewModelFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current
            var startDestination by remember { mutableStateOf<String?>(null) }
            val studenVm: StudentIdViewModel = viewModel(
                factory = StudentIdViewModelFactory(this)
            )
            val loginVm: LoginViewModel = viewModel(
                factory = LoginViewModelFactory(this)
            )

            LaunchedEffect(Unit) {
                val prefs = AppPreferenceManager(context)
                startDestination = if (prefs.isLoggedIn()) {
                    when (prefs.getUserRole()) {
                        "student" -> Routes.STUDENT_DASH
                        "guard" -> Routes.GUARD
                        else -> Routes.LOGIN
                    }
                } else {
                    Routes.LOGIN
                }
            }

            if (startDestination != null) {
                NavHost(
                    navController = navController,
                    startDestination = startDestination!!
                ) {
                    composable(Routes.LOGIN) {
                        LoginScreen(
                            navController = navController,
                            viewModel = loginVm
                        )
                    }
                    composable(Routes.STUDENT_DASH) {

                        StudentDashboardScreen(
                            navController = navController,
                            viewModel = studenVm
                        )
                    }
                    composable(Routes.STUDENT_ID) {

                        StudentIdMainScreen(
                            navController = navController,
                            viewModel = studenVm
                        )
                    }
                    composable(Routes.GUARD) {
                        GuardDashboardScreen()
                    }
                }
            }
        }

    }
}








