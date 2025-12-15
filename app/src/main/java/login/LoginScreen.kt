package login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mycollagelocker.ui.theme.MYCOLLAGELOCKERTheme
import navigation.Routes
import student.StudentIdViewModel


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel

) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

        TextField(
            value = viewModel.fullName,
            onValueChange = { viewModel.onFullNameChange(it) },
            label = { Text("Full Name") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = viewModel.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = viewModel.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(32.dp))

        Column {
            Row {

                RadioButton(
                    selected = viewModel.selectedRole == "student",
                    onClick = { viewModel.updateRole("student") }
                )
                Text("student")
            }

            Row {
                RadioButton(
                    selected = viewModel.selectedRole == "guard",
                    onClick = {viewModel.updateRole("guard") }
                )
                Text("guard")
            }
        }


        Button(
            onClick = {
                if (viewModel.login()) {
                    viewModel.saveLogin()

                    if (viewModel.selectedRole == "student") {
                        navController.navigate(Routes.STUDENT_DASH) {
                            popUpTo ( Routes.LOGIN ) { inclusive = true }
                        }
                    }
                    else {
                        navController.navigate(Routes.GUARD) {
                            popUpTo (Routes.LOGIN ) { inclusive = true }
                        }
                    }
                }
                else {
                    Toast.makeText(context, "invalid input", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("login")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Dont have account! Create here."
        )

    }

}


