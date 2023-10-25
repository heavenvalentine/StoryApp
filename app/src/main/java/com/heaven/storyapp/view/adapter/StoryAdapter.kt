package com.heaven.storyapp.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.heaven.storyapp.R
import com.heaven.storyapp.databinding.ItemRowStoryBinding
import com.heaven.storyapp.view.story.detail.DetailStoryActivity
import com.heaven.storyapp.view.story.response.ListStoryItem

class StoryAdapter(private val listOfStory: List<ListStoryItem>, private val token: String) : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemRowStoryBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val story = listOfStory[position]
        val token = token

        holder.binding.apply {
            tvStoryTitle.text = story.name
            tvItemDescription.text = story.description

            Glide.with(cardView.context)
                .load(story.photoUrl)
                .error(R.drawable.ic_place_holder)
                .into(ivStoryPhoto)

            cardView.setOnClickListener {
                val intent = Intent(cardView.context, DetailStoryActivity::class.java)
                intent.putExtra(DetailStoryActivity.EXTRA_ID, story.id)
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

    override fun getItemCount(): Int = listOfStory.size
}