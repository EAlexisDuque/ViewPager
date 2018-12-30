package programming.app.eduque.viewpager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import programming.app.eduque.viewpager.adapters.SlideAdapter
import programming.app.eduque.viewpager.adapters.pagertransformers.ShadowTransformer


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = SlideAdapter(supportFragmentManager)

        slideViewPager?.apply {
            this.adapter = adapter
            offscreenPageLimit = adapter.count
            pageMargin = -80
            addOnPageChangeListener(ShadowTransformer(adapter))
        }
    }
}
