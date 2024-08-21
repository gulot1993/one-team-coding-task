package com.example.one_team_coding_challenge.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B: ViewDataBinding> : Fragment() {

    private var _binding: B? = null

    abstract fun resId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil
            .inflate(
                inflater,
                resId(),
                container,
                false
            )
        _binding?.lifecycleOwner = viewLifecycleOwner
        return _binding?.root
    }

    override fun onDestroyView() {
        _binding?.unbind()
        _binding = null
        super.onDestroyView()
    }
}