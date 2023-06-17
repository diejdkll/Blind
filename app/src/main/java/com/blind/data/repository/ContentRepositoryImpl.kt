package com.blind.data.repository

import com.blind.data.model.ContentMapper.toRequest
import com.blind.data.source.remote.ContentService
import com.blind.domain.model.Content
import com.blind.domain.repository.ContentRepository
import java.io.IOException
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentService: ContentService
) : ContentRepository {

    override suspend fun save(item: Content): Boolean {
        return try {
            contentService.saveItem(item.toRequest())
            true
        } catch (e: IOException) {
            false
        }
    }
}