package com.jewan.studyandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jewan.studyandroid.ui.theme.StudyAndroidTheme

class MainActivity : ComponentActivity() { // 안드로이드의 시작점, Activity는 화면이라고 생각하면 됨 -> 사용자 인터페이스를 가진 단일 화면
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Jewan",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable // 화면에 보이는 요소
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true) // 미리 볼 수 있게 만들어주는 어노테이션
@Composable
fun GreetingPreview() {
    StudyAndroidTheme {
        Greeting("Jewan")
    }
}