package com.rajkarnikarunish.currex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.rajkarnikarunish.currex.Constants.Companion.API_KEY
import com.rajkarnikarunish.currex.api.ExchangeAPI
import com.rajkarnikarunish.currex.api.RetrofitInstance
import com.rajkarnikarunish.currex.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitInstance.api.getAllRatesBaseUSD(apiKey = "Bearer $API_KEY")
            Log.e("Main Activity", "Reponse--->$response")
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.more, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
//        R.id.settings -> {
//            println("Settings")
//            true
//        }
//        else -> {
//            super.onOptionsItemSelected(item)
//        }
//    }
}