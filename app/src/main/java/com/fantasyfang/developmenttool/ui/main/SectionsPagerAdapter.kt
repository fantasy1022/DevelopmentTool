package com.fantasyfang.developmenttool.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fantasyfang.developmenttool.ui.DeviceInfoFragment
import com.fantasyfang.developmenttool.ui.screen.ScreenInfoFragment

/**
 * A [FragmentStateAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

class SectionsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
//        PlaceholderFragment.newInstance(position + 1)
        return when (position) {
            0 -> ScreenInfoFragment.newInstance()
            1 -> DeviceInfoFragment.newInstance()
            else -> throw IllegalArgumentException()
        }
    }
}