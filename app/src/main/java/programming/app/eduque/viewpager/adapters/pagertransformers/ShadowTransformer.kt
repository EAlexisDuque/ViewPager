package programming.app.eduque.viewpager.adapters.pagertransformers

import android.support.v4.view.ViewPager
import programming.app.eduque.viewpager.adapters.SlideAdapter
import programming.app.eduque.viewpager.adapters.SlideAdapter.Companion.MAX_ELEVATION_FACTOR


class ShadowTransformer(private val adapter: SlideAdapter) : ViewPager.OnPageChangeListener {

    private var ultimoDesplazamiento: Float = 0.toFloat()

    override fun onPageScrolled(position: Int, posicionDeDesplazamiento: Float, positionOffsetPixels: Int) {
        val posicionActualReal: Int
        val sigPosicion: Int
        val baseElevacion = 4
        val desplazamientoReal: Float
        val yendoALaIzq = ultimoDesplazamiento > posicionDeDesplazamiento

        if (yendoALaIzq) {
            posicionActualReal = position + 1
            sigPosicion = position
            desplazamientoReal = 1 - posicionDeDesplazamiento
        } else {
            sigPosicion = position + 1
            posicionActualReal = position
            desplazamientoReal = posicionDeDesplazamiento
        }

        if (sigPosicion > adapter.count - 1 || posicionActualReal > adapter.count - 1) return

        val cardActual = adapter.getCurrentCard(posicionActualReal) ?: return
        cardActual.cardElevation = baseElevacion + (baseElevacion * (MAX_ELEVATION_FACTOR) * (1 - desplazamientoReal))


        val cardSig = adapter.getCurrentCard(sigPosicion) ?: return
        cardSig.cardElevation = baseElevacion + (baseElevacion * (MAX_ELEVATION_FACTOR) * desplazamientoReal)


        ultimoDesplazamiento = posicionDeDesplazamiento
    }

    override fun onPageScrollStateChanged(p0: Int) {}

    override fun onPageSelected(p0: Int) {}
}