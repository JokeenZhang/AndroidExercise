package com.zzq.component.activity.lifecycle

import android.os.Bundle
import com.zzq.component.R
import com.zzq.base.ui.BaseActivity

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }
}