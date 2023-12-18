package com.rajkarnikarunish.currex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.rajkarnikarunish.currex.utils.Constants.Companion.API_KEY
import com.rajkarnikarunish.currex.api.RetrofitInstance
import com.rajkarnikarunish.currex.database.CurreXDB
import com.rajkarnikarunish.currex.databinding.ActivityMainBinding
import com.rajkarnikarunish.currex.models.RatesResponse
import com.rajkarnikarunish.currex.repository.RatesRepository
import com.rajkarnikarunish.currex.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Response
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    
    lateinit var ratesViewModel: RatesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        
        val ratesRepository = RatesRepository(CurreXDB(this))
        val ratesViewModelFactory = RatesViewModelProviderFactory(ratesRepository)

        ratesViewModel = ViewModelProvider(this, ratesViewModelFactory)[RatesViewModel::class.java]

//        val rates : MutableLiveData<Resource<RatesResponse>> = MutableLiveData()
//
//        CoroutineScope(Dispatchers.IO).launch {
////            val response = RetrofitInstance.api.getAllRatesBaseUSD(apiKey = "Bearer $API_KEY")
//            rates.postValue(Resource.Loading())
//            val response = ratesRepository.getRates()
//            Log.e("Main Activity", "Response--->$response")
//            response.body()?.let { ratesRepository.upsert(it) }
//            rates.postValue(handleRatesResponse(response))
//        }
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