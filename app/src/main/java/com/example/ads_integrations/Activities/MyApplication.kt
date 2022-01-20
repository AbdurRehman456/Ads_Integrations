package com.example.ads_integrations.Activities

import android.app.Application
import android.util.Log
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd

class MyApplication : Application() {
    private var mInterstitialAd: InterstitialAd? = null
    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this)
        { initializationStatus ->
            val statusMap =
                initializationStatus.adapterStatusMap
            for (adapterClass in statusMap.keys) {
                val status = statusMap[adapterClass]
                Log.d(
                    "MyApp", String.format(
                        "Adapter name: %s, Description: %s, Latency: %d",
                        adapterClass,
                        status!!.description,
                        status.latency
                    )
                )
            }
        }

    }
}