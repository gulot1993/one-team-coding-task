package com.example.one_team_coding_challenge.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.one_team_coding_challenge.R
import com.example.one_team_coding_challenge.base.BaseFragment
import com.example.one_team_coding_challenge.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun resId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}