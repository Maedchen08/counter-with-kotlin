package com.enigma.fragmentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener, CounterInterface {

    private var counter = 0
    private lateinit var counterFragment: CounterFragment
    private lateinit var showCounterFragment: ShowCounterFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        counterFragment = CounterFragment()
        showCounterFragment = ShowCounterFragment()

        counterFragmentButton.setOnClickListener(this)
        counterShowFragmentButton.setOnClickListener(this)
        supportFragmentManager.beginTransaction().add(
            R.id.fragmentContainer,
            counterFragment
        ).commit()
    }

//mengganti halaman
    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment).commit()


    }

    override fun onClick(v: View?) {
        when (v) {
            counterFragmentButton -> {
                switchFragment(counterFragment)
            }
            counterShowFragmentButton -> {
                showCounterFragment.counter = counter
                switchFragment(showCounterFragment)
            }
        }
    }

    override fun decrement() {
        counter-=1
    }

    override fun increment() {
        counter+=1
    }
}