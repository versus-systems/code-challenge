package com.versus.androidcodetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.versus.androidcodetest.databinding.DashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val recyclerViewAdapter = DashboardViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val boundView = DashboardBinding.inflate(LayoutInflater.from(this))
        recyclerView = boundView.dashboardRecyclerView
        initCollection()
        setContentView(boundView.root)
    }

    private fun initCollection() {
        recyclerView.apply {
            adapter = recyclerViewAdapter
            layoutManager = GridLayoutManager(
                this@DashboardActivity,
                2,
                GridLayoutManager.VERTICAL,
                false
            )
        }
    }
}