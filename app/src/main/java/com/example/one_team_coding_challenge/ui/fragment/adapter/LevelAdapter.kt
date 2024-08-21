package com.example.one_team_coding_challenge.ui.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.one_team_coding_challenge.R
import com.example.one_team_coding_challenge.databinding.ItemLevelBinding
import com.example.one_team_coding_challenge.model.domain.Level

class LevelAdapter(
    private val context: Context
) : RecyclerView.Adapter<LevelAdapter.LevelViewHolder>() {

    private var levels: MutableList<Level> = mutableListOf()

    inner class LevelViewHolder(private val binding: ItemLevelBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(level: Level) {
            with(binding) {
                ivLevel.setImageDrawable(context.getDrawable(R.drawable.ic_level))
                tvTitle.text = level.title
                tvDescription.text = level.description
                tvLevel.text = context.getString(R.string.level, level.level)

                rvActivities.apply {
                    val activityAdapter = LevelActivityAdapter(context, level.activities)
                    adapter = activityAdapter
                    layoutManager = GridLayoutManager(
                        context,
                        2,
                        GridLayoutManager.VERTICAL,
                        false
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(
                R.layout.item_level,
                parent,
                false
            )
        return LevelViewHolder(
            ItemLevelBinding.bind(view)
        )
    }

    fun setData(levels: List<Level>) {
        this.levels.addAll(levels)
    }

    override fun getItemCount(): Int {
        return this.levels.count()
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        holder.bind(level = levels[position])
    }
}