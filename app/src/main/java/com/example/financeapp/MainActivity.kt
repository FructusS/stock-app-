package com.example.financeapp


import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.beust.klaxon.Klaxon
import kotlinx.android.synthetic.main.activity_main.*


import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import javax.net.ssl.SSLSocketFactory
import com.example.financeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainViewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java)}
    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var webSocketClient: WebSocketClient


    public lateinit var recyclerView: RecyclerView
    var messageclone : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_main)
        val adapter = MyAdapter()

        recyclerView = findViewById(R.id.rv_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.swapData(mainViewModel.listTrade.toMutableList())

    }



    override fun onResume() {
        super.onResume()
        mainViewModel.initWebSocket()
    }
//    private fun fillList(message: String?){
//        val data = mutableListOf<Trades>()
//
//        runOnUiThread {
//            try {
//                val klaxon = message?.let { Klaxon().parse<Trade>(it) }
//                if (klaxon != null) {
//                    for (i in klaxon.data) {
//                        // FIXME: 10.05.2022 on CASE
//                        when (i.s) {
//                            "AAPL" -> {
//                                data.add(Trades(1,i.s, i.p))
//
//                            }
//                            "MSFT" -> {
//                                data.add(Trades(2,i.s, i.p))
//
//                            }
//                            else -> {
//                                data.add(Trades(3,i.s, i.p))
//                            }
//                        }
//                    }
//                }
//
//
//
//
//            } catch (e: Exception) {
//                e.message?.let { Log.i("123", it) }
//            }
////            binding.rvMain.apply{
////                adapter = Adapter(data)
////
////                layoutManager = LinearLayoutManager(context)
////            }
////                adapter = Adapter(data)
////            recyclerView.layoutManager = LinearLayoutManager(this)
////            adapter.notifyDataSetChanged()
////            recyclerView.adapter = Adapter(data)
//            recyclerView.adapter = adapter
//            recyclerView.layoutManager = LinearLayoutManager(this)
//
//
//
//            adapter.swapData(data)
//        }
//
//
//
//    }


    override fun onPause() {
        super.onPause()
        webSocketClient.close()
    }
}
//https://developer.android.com/guide/topics/ui/layout/recyclerview
//https://proandroiddev.com/flexible-recyclerview-adapter-with-mvvm-and-data-binding-74f75caef66a