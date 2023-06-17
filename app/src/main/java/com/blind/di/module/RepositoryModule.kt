package com.blind.di.module

import com.blind.data.repository.ContentRepositoryImpl
import com.blind.data.source.remote.ContentService
import com.blind.domain.repository.ContentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesContentRepository(
        contentService: ContentService
    ): ContentRepository = ContentRepositoryImpl(contentService)
}