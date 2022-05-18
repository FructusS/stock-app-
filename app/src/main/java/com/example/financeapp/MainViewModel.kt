package com.example.financeapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beust.klaxon.Klaxon
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import javax.net.ssl.SSLSocketFactory

class MainViewModel : ViewModel() {
    private lateinit var webSocketClient: WebSocketClient
    var listTrade = mutableListOf<Trades>()
    var trades = mutableListOf<Trades>()
    var messageclone = ""

    public fun getList() : MutableList<Trades>{
        return listTrade;
    }

    public fun initWebSocket() {
        val coinbaseUri: URI? = URI("wss://ws.finnhub.io?token=c97gh4iad3iapkilqfog")

        createWebSocketClient(coinbaseUri)
        val socketFactory: SSLSocketFactory = SSLSocketFactory.getDefault() as SSLSocketFactory
        webSocketClient.setSocketFactory(socketFactory)
        webSocketClient.connect()
    }

    public fun createWebSocketClient(coinbaseUri: URI?) {
        webSocketClient = object : WebSocketClient(coinbaseUri) {

            override fun onOpen(handshakedata: ServerHandshake?) {
                Log.i("123", "onOpen")
                subscribe()
            }

            override fun onMessage(message: String?) {
                // Log.i("123", "onMessage: $message")
                //textView = findViewById(R.id.btc_price_tv)
                //runOnUiThread { textView.text = "1 BTC: ${message} €" }
                if (message != null) {
                    messageclone = message
                }
                fillList(message);


            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Log.i("123", "onClose")

            }

            override fun onError(ex: Exception?) {
                Log.i("createWebSocketClient", "onError: ${ex?.message}")
            }


        }


    }

    public fun fillList(message: String?) {
        val data = mutableListOf<Trades>()
        try {
            val klaxon = message?.let { Klaxon().parse<Trade>(it) }
            if (klaxon != null) {
                for (i in klaxon.data) {
                    // FIXME: 10.05.2022 on CASE
                    when (i.s) {
                        "AAPL" -> {
                            trades.add(Trades(1, i.s, i.p))

                        }
                        "MSFT" -> {
                            trades.add(Trades(2, i.s, i.p))

                        }
                        else -> {
                            trades.add(Trades(3, i.s, i.p))
                        }
                    }
                }
            }


        } catch (e: Exception) {
            e.message?.let { Log.i("123", it) }
        }

//            recyclerView.adapter = adapter
//            recyclerView.layoutManager = LinearLayoutManager(this)
//
//
//
//            adapter.swapData(data)

        listTrade.addAll(data)
    }

    public fun subscribe() {
        webSocketClient.send(
            "{\n" +
                    "    \"type\": \"subscribe\",\n" +
                    "    \"symbol\": \"AAPL\" " +
                    "}"
        )
//        webSocketClient.send(
//            "{\n" +
//                    "    \"type\": \"subscribe\",\n" +
//                    "    \"symbol\": \"BINANCE:BTCUSDT\" " +
//                    "}"
//        )
//        webSocketClient.send(
//            "{\n" +
//                    "    \"type\": \"subscribe\",\n" +
//                    "    \"symbol\": \"MSFT\" " +
//
//                    "}"
//        )
    }



}