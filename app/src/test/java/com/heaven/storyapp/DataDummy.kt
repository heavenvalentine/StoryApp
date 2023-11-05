package com.heaven.storyapp

import com.heaven.storyapp.view.data.retrofit.response.ListStoryItem

object DataDummy {
    fun generateDummyStoryResponse(): List<ListStoryItem> {
        val items: MutableList<ListStoryItem> = arrayListOf()
        for (i in 0..100) {
            val story = ListStoryItem(
                i.toString(),
                "createdAt + $i",
                "name $i",
                "description $i",
                "id $i",
                0.0,
                0.0,
            )
            items.add(story)
        }
        return items
    }
}
