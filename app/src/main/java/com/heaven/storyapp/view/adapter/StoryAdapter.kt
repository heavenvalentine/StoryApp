package com.heaven.storyapp.view.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.heaven.storyapp.R
import com.heaven.storyapp.databinding.ItemRowStoryBinding
import com.heaven.storyapp.view.story.ListStoryItem

class StoryAdapter(private val listOfStory: List<ListStoryItem>) : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemRowStoryBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val story = listOfStory[position]

        holder.binding.apply {
            tvStoryTitle.text = story.name
            tvItemDescription.text = story.description

            Glide.with(cardView.context)
                .load(story.photoUrl)
                .error(R.drawable.image_dicoding)
                .into(ivStoryPhoto)

//            itemView.setOnClickListener {
//                val intent = Intent(itemView.context, DetailActivity::class.java)
//                intent.putExtra(DetailActivity.EXTRA_USERNAME, user.login)
//                itemView.context.startActivity(intent)
//            }
        }

    }

    override fun getItemCount(): Int = listOfStory.size
}