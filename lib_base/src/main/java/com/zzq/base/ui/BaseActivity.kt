package com.zzq.base.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private val currentObj = this.javaClass.name
    private val identityHashCode = System.identityHashCode(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("tetetetete", "${currentObj} onCreate, $identityHashCode")
    }

    override fun onStart() {
        super.onStart()
        Log.e("tetetetete", "${currentObj} onStart, $identityHashCode")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("tetetetete", "${currentObj} onRestart, $identityHashCode")
    }

    override fun onResume() {
        super.onResume()
        Log.e("tetetetete", "${currentObj} onResume, $identityHashCode")
    }

    override fun onPause() {
        super.onPause()
        Log.e("tetetetete", "${currentObj} onPause, $identityHashCode")
    }

    override fun onStop() {
        super.onStop()
        Log.e("tetetetete", "${currentObj} onStop, $identityHashCode")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("tetetetete", "${currentObj} onDestroy, $identityHashCode")
    }
}