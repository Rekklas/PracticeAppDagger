package com.rekklesdroid.practiceappdagger.ui.main.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rekklesdroid.practiceappdagger.R
import com.rekklesdroid.practiceappdagger.models.Post
import kotlinx.android.synthetic.main.layout_post_list_item.view.*
import kotlin.properties.Delegates

/**
 * Created on 9/19/2020 by eduard.kovalchuk
 */
class PostsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var posts: List<Post> by Delegates.observable(mutableListOf()) { prop, old, new ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_post_list_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        (holder as PostViewHolder).bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            itemView.title.text = post.title
        }
    }
}
