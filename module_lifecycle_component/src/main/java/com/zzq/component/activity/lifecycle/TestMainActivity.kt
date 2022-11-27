package com.zzq.component.activity.lifecycle

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.LogPrinter
import android.view.View
import android.view.View.OnClickListener
import com.dylanc.viewbinding.binding
import com.zzq.base.ui.BaseActivity
import com.zzq.component.R
import com.zzq.component.databinding.ActivityTestMainBinding

class TestMainActivity : BaseActivity(), OnClickListener {

    private val viewBinding: ActivityTestMainBinding by binding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //打印消息队列
        Looper.getMainLooper().setMessageLogging(LogPrinter(4, "tetetetete-handler"))
        setContentView(R.layout.activity_test_main)

        viewBinding.btn1.setOnClickListener(this)

        val handler = Handler(Looper.getMainLooper())
        handler.post {
            Log.e("tetetetete", "获取宽高 handler post: ${viewBinding.btn1.width}")
        }
        Log.e("tetetetete", "获取宽高 onCreate: ${viewBinding.btn1.width}")
    }

    override fun onResume() {
        super.onResume()
        Log.e("tetetetete", "获取宽高 onResume: ${viewBinding.btn1.width}")
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btn_1 -> {
                //查看Activity生命周期执行顺序，只需要 TestMainActivity 和 FirstActivity
                startActivity(Intent(this, FirstActivity::class.java))
            }
        }
    }
}