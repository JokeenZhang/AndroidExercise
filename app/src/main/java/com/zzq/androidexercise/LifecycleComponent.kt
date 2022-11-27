package com.zzq.androidexercise

import android.content.Intent
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzq.component.activity.lifecycle.TestMainActivity

@Composable
fun ColumnScope.ShowLifecycleComponentRoute() {
    val context = LocalContext.current
    Button(onClick = { context.startActivity(Intent(context, TestMainActivity::class.java)) }) {
        CenterFillText("Test Activity")
    }
}

/**
 * 对Text做封装
 * 占用全部宽度，文本居中
 */
@Composable
fun CenterFillText(text: String, fontSize: TextUnit = 15.sp) {
    Text(
        text = text,
        fontSize = fontSize,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
        textAlign = TextAlign.Center
    )
}