package xyz.teamgravity.cleanarchitecturevalidation.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest
import xyz.teamgravity.cleanarchitecturevalidation.R
import xyz.teamgravity.cleanarchitecturevalidation.core.util.UniversalText
import xyz.teamgravity.cleanarchitecturevalidation.presentation.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    viewmodel: RegisterViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = viewmodel.event) {
        viewmodel.event.collectLatest { event ->
            when (event) {
                RegisterViewModel.RegisterEvent.Success -> {
                    Toast.makeText(context, context.getString(R.string.successful_registered), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = viewmodel.mail,
            onValueChange = viewmodel::onMailChange,
            isError = viewmodel.errorMail !is UniversalText.Empty,
            label = {
                Text(text = stringResource(id = R.string.mail))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier.fillMaxWidth()
        )
        if (viewmodel.errorMail !is UniversalText.Empty) {
            Text(
                text = viewmodel.errorMail.asString(),
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = viewmodel.password,
            onValueChange = viewmodel::onPasswordChange,
            isError = viewmodel.errorPassword !is UniversalText.Empty,
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (viewmodel.errorPassword !is UniversalText.Empty) {
            Text(
                text = viewmodel.errorPassword.asString(),
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = viewmodel.submissionPassword,
            onValueChange = viewmodel::onSubmissionPasswordChange,
            isError = viewmodel.errorSubmissionPassword !is UniversalText.Empty,
            label = {
                Text(text = stringResource(id = R.string.submission_password))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (viewmodel.errorSubmissionPassword !is UniversalText.Empty) {
            Text(
                text = viewmodel.errorSubmissionPassword.asString(),
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = viewmodel.termsConditionChecked,
                onCheckedChange = viewmodel::onTermsConditionCheckedChange
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = stringResource(id = R.string.accept_terms_condition))
        }
        if (viewmodel.errorTermsConditionChecked !is UniversalText.Empty) {
            Text(
                text = viewmodel.errorTermsConditionChecked.asString(),
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = viewmodel::onRegister,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.register))
        }
    }
}