package com.zzq.androidexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dylanc.viewbinding.binding
import com.zzq.androidexercise.databinding.ActivityMainBinding
import com.zzq.androidexercise.ui.theme.AndroidExerciseTheme
import com.zzq.base.ui.BaseActivity
import com.zzq.component.activity.lifecycle.FirstActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //全部水平居中
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        ShowLifecycleComponentRoute()
                    }
                }
            }
        }
    }
}