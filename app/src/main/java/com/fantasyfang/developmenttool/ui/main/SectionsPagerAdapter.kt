package com.fantasyfang.developmenttool.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fantasyfang.developmenttool.ui.device.DeviceInfoFragment
import com.fantasyfang.developmenttool.ui.id.IdInfoFragment
import com.fantasyfang.developmenttool.ui.screen.ScreenInfoFragment

/**
 * A [FragmentStateAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

class SectionsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3 //Use item count

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ScreenInfoFragment.newInstance()
            1 -> DeviceInfoFragment.newInstance()
            2 -> IdInfoFragment.newInstance()
            else -> throw IllegalArgumentException()
        }
    }
}