package com.example.one_team_coding_challenge.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.one_team_coding_challenge.R
import com.example.one_team_coding_challenge.base.BaseFragment
import com.example.one_team_coding_challenge.databinding.FragmentHomeBinding
import com.example.one_team_coding_challenge.model.domain.Level
import com.example.one_team_coding_challenge.ui.fragment.adapter.LevelAdapter
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModels<HomeViewModel>()
    private var adapter: LevelAdapter? = null


    override fun resId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupViewModel()
    }

    private fun setupListeners() {
        val tabLayout = binding!!.tabLayout
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.setIcon(R.drawable.ic_tab_selected)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.setIcon(R.drawable.ic_tab_not_selected)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.setIcon(R.drawable.ic_tab_selected)
            }

        })
    }

    private fun setupRecyclerView(items: List<Level>) {
        binding?.rvLevel?.apply {
            this@HomeFragment.adapter = LevelAdapter(requireContext()).apply {
                setData(items)
            }
            adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }

    private fun setupViewModel() {
        viewModel.saveAndLoadTemperLevels()
        lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                launch {
                    viewModel.levelWithActivities.collectLatest {
                        setupRecyclerView(it)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        adapter = null
        super.onDestroy()
    }
}