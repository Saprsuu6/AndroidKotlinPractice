package com.example.admob

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.admob.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(
            this
        ) { }

        val adRequest = AdRequest.Builder().build()

        // region Banners
        binding.adViewBanner.loadAd(adRequest)
        binding.adViewLargeBanner.loadAd(adRequest)
        binding.adViewMediumRectangle.loadAd(adRequest)
        binding.adViewLeaderBoard.loadAd(adRequest)
        binding.adViewSmartBanner.loadAd(adRequest)
        binding.adViewBanner.adListener = object : AdListener() {
            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdClosed() {
                super.onAdClosed()
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
            }

            override fun onAdOpened() {
                super.onAdOpened()
            }

            override fun onAdSwipeGestureClicked() {
                super.onAdSwipeGestureClicked()
            }
        }
        // endregion

        // region Interstitial ad
        val interstitialAd = Runnable {
            if (mInterstitialAd != null) {
                mInterstitialAd?.apply {
                    fullScreenContentCallback = object : FullScreenContentCallback() {
                        override fun onAdClicked() {
                            super.onAdClicked()
                        }

                        override fun onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent()
                        }

                        override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                            super.onAdFailedToShowFullScreenContent(p0)
                        }

                        override fun onAdImpression() {
                            super.onAdImpression()
                        }

                        override fun onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent()
                        }
                    }
                    mInterstitialAd?.show(this@MainActivity)
                }
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }
        }

        InterstitialAd.load(this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(error: LoadAdError) {
                    Log.d("Fail to load InterstitialAd", error.toString())
                    this@MainActivity.mInterstitialAd = null
                }

                override fun onAdLoaded(interstaionalAd: InterstitialAd) {
                    super.onAdLoaded(interstaionalAd)
                    this@MainActivity.mInterstitialAd = interstaionalAd
                    interstitialAd.run()
                }
            })
        // endregion
    }
}