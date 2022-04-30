package xyz.teamgravity.cleanarchitecturevalidation.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.teamgravity.cleanarchitecturevalidation.core.util.AndroidMailMatcher
import xyz.teamgravity.cleanarchitecturevalidation.domain.usecase.util.MailMatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideMailMatcher(): MailMatcher = AndroidMailMatcher()
}