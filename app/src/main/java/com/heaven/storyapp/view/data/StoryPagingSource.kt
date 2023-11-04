package com.heaven.storyapp.view.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.heaven.storyapp.view.data.retrofit.ApiService
import com.heaven.storyapp.view.data.retrofit.response.ListStoryItem

class StoryPagingSource(
    private val apiService: ApiService,
    private val token: String
) : PagingSource<Int, ListStoryItem>() {

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListStoryItem> {
        return try {
            val page = params.key ?: INITIAL_PAGE_INDEX
            val response = apiService.getStories("Bearer $token", page, params.loadSize)
            val stories = response.listStory
            val prevKey = if (page == 1) null else page - 1
            val nextKey = if (stories.isNotEmpty()) page + 1 else null

            LoadResult.Page(
                data = stories,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ListStoryItem>): Int? {
        return state.anchorPosition
    }
}