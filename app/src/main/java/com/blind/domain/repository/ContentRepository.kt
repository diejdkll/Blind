package com.blind.domain.repository

import com.blind.domain.model.Content

interface ContentRepository {

    suspend fun save(item: Content): Boolean
}