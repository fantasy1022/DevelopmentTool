package com.fantasyfang.developmenttool.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.fantasyfang.developmenttool.R
import com.fantasyfang.developmenttool.databinding.ActivityMainBinding
import com.fantasyfang.developmenttool.di.GenericSavedStateViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    //For test
    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels {
        GenericSavedStateViewModelFactory(
            viewModelFactory,
            this,
            intent.extras
        )
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = SectionsPagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }
}

private val TAB_TITLES = arrayOf(
    R.string.tab_text_screen,
    R.string.tab_text_device,
    R.string.tab_text_id
)