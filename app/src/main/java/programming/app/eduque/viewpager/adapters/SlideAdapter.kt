package programming.app.eduque.viewpager.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.CardView
import programming.app.eduque.viewpager.fragments.FragmentFour
import programming.app.eduque.viewpager.fragments.FragmentOne
import programming.app.eduque.viewpager.fragments.FragmentThree
import programming.app.eduque.viewpager.fragments.FragmentTwo

class SlideAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val fragmentList: MutableList<Fragment> = ArrayList<Fragment>().apply {
        add(FragmentOne())
        add(FragmentTwo())
        add(FragmentThree())
        add(FragmentFour())
    }

    override fun getItem(p0: Int): Fragment = fragmentList[p0]

    override fun getCount(): Int = fragmentList.size

    fun getCurrentCard(position: Int): CardView? {
        return when (fragmentList[position]) {
            is FragmentOne -> (fragmentList[position] as FragmentOne).getCardView()
            is FragmentTwo -> (fragmentList[position] as FragmentTwo).getCardView()
            is FragmentThree -> (fragmentList[position] as FragmentThree).getCardView()
            is FragmentFour -> (fragmentList[position] as FragmentFour).getCardView()
            else -> null
        }
    }

    companion object {
        const val MAX_ELEVATION_FACTOR = 6
    }
}