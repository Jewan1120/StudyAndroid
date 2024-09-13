package com.jewan.studyandroid.shopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("물품 추가하기")
                        }
                        // 항목이 추가되거나 삭제되면 자동으로 업데이트
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            items(sItems) { }
                        }
                    }
                }
            }
        }
    }
}

data class ShoppingItem( // 데이터 객체
    val id: Int,
    var name: String,
    var quantitiy: Int,
    var isEditing: Boolean = false
)