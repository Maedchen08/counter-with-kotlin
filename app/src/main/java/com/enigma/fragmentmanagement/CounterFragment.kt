package com.enigma.fragmentmanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_counter.*


class CounterFragment : Fragment() {

    private lateinit var counterHandler: CounterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        counterHandler= activity as CounterInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        increaseButton.setOnClickListener{counterHandler.increment()}
        decreaseButton.setOnClickListener{counterHandler.decrement()}
    }

//    override fun onClick(v: View?){
//        when(v){
//            increaseButton -> {
//                counterHandler.increment()
//            }
//            decreaseButton -> {
//                println("decrease button dipnaggil")
//                counterHandler.decrement()
//            }
//
//        }
//    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CounterFragment()
    }
}