package com.example.circlemenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.circlemenu.databinding.ActivityMainBinding
import com.ramotion.circlemenu.CircleMenuView
import com.ramotion.circlemenu.CircleMenuView.EventListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setListeners() {
        binding.circleMenu.eventListener = object : EventListener() {
            override fun onMenuOpenAnimationStart(view: CircleMenuView) {
                super.onMenuOpenAnimationStart(view)
            }

            override fun onMenuOpenAnimationEnd(view: CircleMenuView) {
                super.onMenuOpenAnimationEnd(view)
            }

            override fun onMenuCloseAnimationStart(view: CircleMenuView) {
                super.onMenuCloseAnimationStart(view)
            }

            override fun onMenuCloseAnimationEnd(view: CircleMenuView) {
                super.onMenuCloseAnimationEnd(view)
            }

            override fun onButtonClickAnimationStart(view: CircleMenuView, buttonIndex: Int) {
                super.onButtonClickAnimationStart(view, buttonIndex)
            }

            override fun onButtonClickAnimationEnd(view: CircleMenuView, buttonIndex: Int) {
                super.onButtonClickAnimationEnd(view, buttonIndex)
            }

            override fun onButtonLongClick(view: CircleMenuView, buttonIndex: Int): Boolean {
                return super.onButtonLongClick(view, buttonIndex)
            }

            override fun onButtonLongClickAnimationStart(view: CircleMenuView, buttonIndex: Int) {
                super.onButtonLongClickAnimationStart(view, buttonIndex)
            }

            override fun onButtonLongClickAnimationEnd(view: CircleMenuView, buttonIndex: Int) {
                super.onButtonLongClickAnimationEnd(view, buttonIndex)
            }
        }
    }
}