package com.example.a16_zadanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a16_zadanie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val adapter=PlantAdapter()
private val imageIDList= listOf(

    R.drawable.pok_001,
    R.drawable.pok_002,
    R.drawable.pok_003,

)
    private var index=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()


    }

    private fun init(){
        binding.apply {
            rcView.layoutManager=GridLayoutManager(this@MainActivity,3)
            rcView.adapter=adapter

            btnAdd.setOnClickListener {
                if (index>6) index=0
                var plant=Plant(imageIDList[index], "Pokemon $index")
                adapter.addPlant(plant)
                index++

                if(index==3){
                    btnAdd.isEnabled=false

                }
            }

        }
    }
}