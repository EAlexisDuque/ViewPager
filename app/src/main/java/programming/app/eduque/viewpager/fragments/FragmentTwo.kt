package programming.app.eduque.viewpager.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import kotlinx.android.synthetic.main.view_pager_card_view_template.*
import programming.app.eduque.viewpager.R

class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.view_pager_card_view_template, container, false)
        val layoutPlantilla = view.findViewById<ViewStub>(R.id.includeLayout)
        layoutPlantilla.layoutResource = R.layout.fragment_two
        layoutPlantilla.inflate()

        return view
    }

    fun getCardView(): CardView? {
        return myGeneralCardView
    }
}
