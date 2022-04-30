package xyz.teamgravity.cleanarchitecturevalidation.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.teamgravity.cleanarchitecturevalidation.core.util.UniversalText
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation.*
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val handle: SavedStateHandle,
    private val validateMail: ValidateMail,
    private val validatePassword: ValidatePassword,
    private val validateSubmissionPassword: ValidateSubmissionPassword,
    private val validateTermsCondition: ValidateTermsCondition
) : ViewModel() {

    companion object {
        private const val MAIL = "mail"
        private const val PASSWORD = "password"
        private const val SUBMISSION_PASSWORD = "submission_password"
        private const val TERMS_CONDITION_CHECKED = "terms_condition_checked"
    }

    var mail: String by mutableStateOf(handle.get<String>(MAIL) ?: "")
        private set

    var password: String by mutableStateOf(handle.get<String>(PASSWORD) ?: "")
        private set

    var submissionPassword: String by mutableStateOf(handle.get<String>(SUBMISSION_PASSWORD) ?: "")
        private set

    var termsConditionChecked: Boolean by mutableStateOf(handle.get<Boolean>(TERMS_CONDITION_CHECKED) ?: false)
        private set

    var errorMail: UniversalText by mutableStateOf(UniversalText.Empty)
        private set

    var errorPassword: UniversalText by mutableStateOf(UniversalText.Empty)
        private set

    var errorSubmissionPassword: UniversalText by mutableStateOf(UniversalText.Empty)
        private set

    var errorTermsConditionChecked: UniversalText by mutableStateOf(UniversalText.Empty)
        private set

    private fun clearErrors() {
        errorMail = UniversalText.Empty
        errorPassword = UniversalText.Empty
        errorSubmissionPassword = UniversalText.Empty
        errorTermsConditionChecked = UniversalText.Empty
    }

    private fun onValidateMail() {
        val result = validateMail(mail)
        if (result is ValidationResult.Error) errorMail = result.message
    }

    private fun onValidatePassword() {
        val result = validatePassword(password)
        if (result is ValidationResult.Error) errorPassword = result.message
    }

    private fun onValidateSubmissionPassword() {
        val result = validateSubmissionPassword(password = password, submissionPassword = submissionPassword)
        if (result is ValidationResult.Error) errorSubmissionPassword = result.message
    }

    private fun onValidateTermsCondition() {
        val result = validateTermsCondition(termsConditionChecked)
        if (result is ValidationResult.Error) errorTermsConditionChecked = result.message
    }

    fun onMailChange(value: String) {
        mail = value
        handle[MAIL] = value
    }

    fun onPasswordChange(value: String) {
        password = value
        handle[PASSWORD] = value
    }

    fun onSubmissionPasswordChange(value: String) {
        submissionPassword = value
        handle[SUBMISSION_PASSWORD] = value
    }

    fun onTermsConditionCheckedChange(value: Boolean) {
        termsConditionChecked = value
        handle[TERMS_CONDITION_CHECKED] = value
    }

    fun onValidate() {
        clearErrors()
        onValidateMail()
        onValidatePassword()
        onValidateSubmissionPassword()
        onValidateTermsCondition()
    }
}