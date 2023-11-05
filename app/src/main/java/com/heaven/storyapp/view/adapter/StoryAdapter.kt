package com.heaven.storyapp.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.heaven.storyapp.R
import com.heaven.storyapp.databinding.ItemRowStoryBinding
import com.heaven.storyapp.view.data.retrofit.response.ListStoryItem
import com.heaven.storyapp.view.story.detail.DetailStoryActivity

class StoryAdapter(private val token: String) : PagingDataAdapter<ListStoryItem, StoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    class ViewHolder(var binding: ItemRowStoryBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val story = getItem(position)
        val token = token

        holder.binding.apply {
            tvStoryTitle.text = story?.name
            tvItemDescription.text = story?.description

            Glide.with(cardView.context)
                .load(story?.photoUrl)
                .error(R.drawable.ic_place_holder)
                .into(ivStoryPhoto)

            cardView.setOnClickListener {
                val intent = Intent(cardView.context, DetailStoryActivity::class.java)
                intent.putExtra(DetailStoryActivity.EXTRA_ID, story?.id)
                intent.putExtra(DetailStoryActivity.EXTRA_TOKEN, token)

                val optionsCompat: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        cardView.context as Activity,
                        Pair(ivStoryPhoto, "trPhoto"),
                        Pair(tvStoryTitle, "trTitle"),
                        Pair(tvItemDescription, "trDesc")
                    )

                cardView.context.startActivity(intent, optionsCompat.toBundle())
            }
        }

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListStoryItem>() {
            override fun areItemsTheSame(oldItem: ListStoryItem, newItem: ListStoryItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ListStoryItem,
                newItem: ListStoryItem
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}