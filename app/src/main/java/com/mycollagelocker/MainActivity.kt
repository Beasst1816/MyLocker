package com.mycollagelocker

    import android.os.Bundle
    import android.widget.TabHost
    import android.widget.Toast
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.Button
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextField
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.internal.composableLambda
    import androidx.compose.runtime.remember
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.input.PasswordVisualTransformation
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.mycollagelocker.ui.theme.MYCOLLAGELOCKERTheme
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.mycollagelocker.ui.theme.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContent {
           val navController = rememberNavController()
           NavHost(
               navController = navController,
               startDestination = "login"
           ) {
               composable("login") { LoginScreenText(navController) }
               composable("home") { HomeScreen() }
           }
       }

    }
}


@Composable
fun LoginScreenText(navHost: NavHostController ,modifier: Modifier = Modifier ) {

   val vm: LoginViewModel = viewModel()
    val context = LocalContext.current



    Text(
        text = " My Collage Lokcer ",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = vm.fullName,
            onValueChange = { vm.fullName  = it },
            label = { Text("Full Name") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = vm.email,
            onValueChange = { vm.email = it },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = vm.password,
            onValueChange = { vm.password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                if (vm.login()) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    navHost.navigate("home")
                }
            }
        ) {
            Text(
                text = "Login"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Dont have account! Create here."
        )

    }

}


@Preview(showBackground = true)
@Composable
fun LoginScreenTextPreview() {
    MYCOLLAGELOCKERTheme {
        LoginScreenText(navHost = rememberNavController())
    }
}

