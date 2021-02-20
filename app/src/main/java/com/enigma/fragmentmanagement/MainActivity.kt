package com.enigma.fragmentmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_show_counter.*

class MainActivity : AppCompatActivity(), CounterInterface {

    private var counter = 0
    private lateinit var counterFragment: CounterFragment
    private lateinit var counterShowFragment: ShowCounterFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterFragment = fragment1 as CounterFragment
        counterShowFragment = fragment2 as ShowCounterFragment
    }

    fun toSecondActivity(view : View){
        startActivity(Intent (this, SecondActivity::class.java))
    }

    override fun decrement() {
        counter = Integer.parseInt(counterValue.text.toString())
        counter--
        counterShowFragment.notif(counter)
    }

    override fun increment() {
        counter = Integer.parseInt(counterValue.text.toString())
        counter++
        counterShowFragment.notif(counter)

    }
}