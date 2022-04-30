package xyz.teamgravity.cleanarchitecturevalidation.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.util.MailMatcher
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation.ValidateMail
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation.ValidatePassword
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation.ValidateSubmissionPassword
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.validation.ValidateTermsCondition

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideValidateMail(mailMatcher: MailMatcher): ValidateMail = ValidateMail(mailMatcher)

    @Provides
    @ViewModelScoped
    fun provideValidatePassword(): ValidatePassword = ValidatePassword()

    @Provides
    @ViewModelScoped
    fun provideValidateSubmissionPassword(): ValidateSubmissionPassword = ValidateSubmissionPassword()

    @Provides
    @ViewModelScoped
    fun provideValidateTermsCondition(): ValidateTermsCondition = ValidateTermsCondition()
}