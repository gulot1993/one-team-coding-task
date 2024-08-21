package com.example.one_team_coding_challenge.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B: ViewDataBinding> : AppCompatActivity() {

    private var _binding: B? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil
            .setContentView(
                this,
                resId()
            )
        _binding?.lifecycleOwner = this
    }

    abstract fun resId(): Int

    override fun onDestroy() {
        _binding?.unbind()
        _binding = null
        super.onDestroy()
    }
}