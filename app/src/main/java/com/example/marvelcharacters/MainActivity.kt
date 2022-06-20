package com.example.marvelcharacters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelcharacters.ui.map.CustomGoogleMap

class MainActivity : AppCompatActivity(R.layout.activity_main)/*{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container_activity,CustomGoogleMap())
                .commit()
        }
    }
}*/