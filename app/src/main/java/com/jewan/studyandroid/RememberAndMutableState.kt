package com.jewan.studyandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.jewan.studyandroid.ui.theme.StudyAndroidTheme
import kotlin.random.Random

class RememberAndMutableState : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MakeFriends()
                }
            }
        }
    }

    @Composable
    fun MakeFriends() {
        // remember : 컴포넌트가 재구성될 때 현재 값을 기억하고 유지
        // state : 요소의 동적 데이터를 저장
        // val makeFriend = remember { mutableIntStateOf(0) }
        var makeFriend by remember { mutableIntStateOf(0) }
        val location = remember { mutableStateOf("집") }
        Column {
            Text(text = "내 친구는 ${makeFriend}명")
            Text(text = "내 위치는 ${location.value}")
            Button(onClick = {
                location.value = "공원"
                if (Random.nextBoolean()) {
                    makeFriend += 1
                }
            }) { Text(text = "공원으로 가기") }
            Button(onClick = {
                location.value = "학교"
                if (Random.nextBoolean()) {
                    makeFriend += 2
                }
            }) { Text(text = "학교로 가기") }
            Button(onClick = {
                location.value = "집"
            }) { Text(text = "집으로 가기") }
        }
    }
}

