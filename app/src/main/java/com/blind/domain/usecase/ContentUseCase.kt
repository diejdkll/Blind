package com.blind.domain.usecase

import com.blind.domain.model.Content
import com.blind.domain.repository.ContentRepository
import javax.inject.Inject

class ContentUseCase @Inject constructor(
    private val contentRepository: ContentRepository
) {
    suspend fun save(item: Content) = contentRepository.save(item)
}