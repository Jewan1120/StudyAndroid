package com.jewan.studyandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jewan.studyandroid.ui.theme.StudyAndroidTheme

class MainActivity :
    ComponentActivity() { // 안드로이드의 시작점, Activity는 화면이라고 생각하면 됨 -> 사용자 인터페이스를 가진 단일 화면
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
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

@Composable
fun ButtonWithToast() {
    Column {
        // 이 부분에 UI요소들을 하나 씩 넣음
        OutlinedTextField(value = "Enter Value", onValueChange = {
            // 실행되어야 할 로직을 입력
        })
        Row {
            val context = LocalContext.current
            Button(onClick = { Toast.makeText(context, "ClickClick", Toast.LENGTH_LONG).show() }) {
                Text("Click")
            }
        }
    }
}

@Preview
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}

@Composable
fun UnitConverter() {
    Column(
        // modifier는 Column의 소괄호 안에 들어가야 함
        modifier = Modifier.fillMaxSize(), // 전체 화면으로 채움
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter")
        OutlinedTextField(value = "", onValueChange = {

        })
        Row {
            Box {
                Button(onClick = {}) {
                    Text("Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        "" // 사용자가 접근성 서비스를 이용하고 있을 때 나타내 줄 설명
                    )
                }
            }
            Box {
                Button(onClick = {}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, "")
                }
            }
        }
    }
}