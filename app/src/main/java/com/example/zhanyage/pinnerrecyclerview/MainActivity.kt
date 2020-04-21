package com.example.zhanyage.pinnerrecyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zhanyage.pinnerrecyclerview.activity.PinnedTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun setListener() {
        btn_main_go_pinned.setOnClickListener {
            startActivity(Intent(this, PinnedTestActivity::class.java))
        }
    }
}
