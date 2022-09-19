package com.afnanelfazary.islamiapp.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afnanelfazary.islamiapp.databinding.FragmentTasbehBinding


class TasbehFragment : Fragment() {
    private lateinit var fragbinding: FragmentTasbehBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //   R.layout.fragment_quran, container, false
        fragbinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return fragbinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragbinding.zekrButton.setOnClickListener {
//            val rotate = RotateAnimation(
//                0F,
//                10F,
//                Animation.RELATIVE_TO_SELF,
//                0.5f,
//                Animation.RELATIVE_TO_SELF,
//                0.5f
//            )
//            rotate.duration = 5000
//            rotate.interpolator = LinearInterpolator()
//            fragbinding.spinnerSebha.startAnimation(rotate)

            fragbinding.spinnerSebha.animate().rotation(360f).setDuration(5000).start()

        }
    }
}