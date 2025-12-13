package student

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import navigation.Routes

@Composable
fun StudentIdMainScreen(
    navController: NavController,
    viewModel: StudentIdViewModel
) {
    when (viewModel.uiMode) {

        IdUiMode.CREATE -> {
            CreateIdScreen(
                initialData = null,
                onSubmit = { viewModel.saveId(it) }
            )
        }

        IdUiMode.VIEW -> {
            PreviewIdScreen(
                data = viewModel.idData!!,
                onEdit = { viewModel.startEdit() },
                onBack = { navController.popBackStack() }
            )
        }

        IdUiMode.EDIT -> {
            CreateIdScreen(
                initialData = viewModel.idData,
                onSubmit = { viewModel.saveId(it) }
            )
        }
    }
}