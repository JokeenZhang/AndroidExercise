package com.zzq.jetpackuse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zzq.jetpackuse.bean.BottomNavItem
import com.zzq.jetpackuse.ui.theme.AndroidExerciseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val roomViewModel:RoomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainPage()
                }
            }
        }
        roomViewModel.createStartupRecord()
    }
}

@Composable
fun MainPage() {

    var selectedItem by remember { mutableStateOf(0) }
    val items = arrayOf(
        BottomNavItem("主页", Icons.Filled.Home),
        BottomNavItem("列表", Icons.Filled.List),
        BottomNavItem("设置", Icons.Filled.Settings),
    )
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "主页") }, navigationIcon = {
                IconButton(onClick = { Log.e("tetetetete", "IconButton click") }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "菜单")
                }
            })
        },
        bottomBar = {
            BottomNavigation {
                items.forEachIndexed { index, bottomNavItem ->
                    BottomNavigationItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = { Icon(bottomNavItem.icon, bottomNavItem.name) },
                        alwaysShowLabel = false, label = { Text(text = bottomNavItem.name) })
                }
            }
        },
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = items[selectedItem].name)
        }
    }


}

@Composable
@Preview
fun MainPagePreview() {
    MainPage()
}