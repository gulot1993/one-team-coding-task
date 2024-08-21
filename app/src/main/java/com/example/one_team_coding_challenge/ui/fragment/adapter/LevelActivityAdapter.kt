package com.example.one_team_coding_challenge.ui.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.one_team_coding_challenge.R
import com.example.one_team_coding_challenge.databinding.ItemLevelActivityBinding
import com.example.one_team_coding_challenge.model.domain.Activity
import com.squareup.picasso.Picasso

class LevelActivityAdapter(
    private val context: Context,
    private val items: List<Activity>
) : RecyclerView.Adapter<LevelActivityAdapter.LevelActivityViewHolder>() {
    inner class LevelActivityViewHolder(private val binding: ItemLevelActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: Activity) {
            with(binding) {
                tvTitle.text = activity.title
                Picasso
                    .get()
                    .load(activity.icon.substring(2))
                    .error(R.drawable.ic_profile)
                    .into(ivActivity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelActivityViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(
                R.layout.item_level_activity,
                parent,
                false
            )
        return LevelActivityViewHolder(
            ItemLevelActivityBinding.bind(view)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: LevelActivityViewHolder, position: Int) {
        holder.bind(items[position])
    }

}