package com.blind.data.model

import com.blind.data.model.dto.ContentDto
import com.blind.domain.model.Content

object ContentMapper {

    fun Content.toRequest() = ContentDto(
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount
    )
}