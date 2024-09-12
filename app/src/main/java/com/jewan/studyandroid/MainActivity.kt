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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jewan.studyandroid.ui.theme.StudyAndroidTheme
import kotlin.math.roundToInt

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
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("0.00") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val iconversionFactor = remember { mutableStateOf(0.01) }
    val oconversionFactor = remember { mutableStateOf(0.01) }

    fun convertUnits() {
        // ?: elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0 // null일 경우 초기화
        val result = (inputValueDouble * iconversionFactor.value / oconversionFactor.value * 100.0).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        // modifier는 Column의 소괄호 안에 들어가야 함
        modifier = Modifier.fillMaxSize(), // 전체 화면으로 채움
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter") // 여기에 Padding을 추가해서 칸을 띄울 수도 있음
        Spacer(modifier = Modifier.height(16.dp)) // 기기 화면 픽셀 밀도에 따른 상대적인 픽셀값
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it // 필드에 적힌 값을 inputValue에 넣어줌
                convertUnits()  // 값이 적힐 때마다 계산
            },
            label = { Text("Enter Value") }, // label은 그냥 표시
            placeholder = { Text("Do it") }) // placeholder는 커서로 눌렀을 때 표시
        Row {
            Box {
                Button(onClick = { iExpanded = true }) { // 드롭다운 표시
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown, "")
                }
                DropdownMenu(
                    expanded = iExpanded,
                    onDismissRequest = { iExpanded = false }) { // 취소되면 닫기
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Centimeters"
                        iconversionFactor.value = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Meters"
                        iconversionFactor.value = 1.0
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text("Kilometers") }, onClick = {
                        iExpanded = false
                        inputUnit = "Kilometers"
                        iconversionFactor.value = 1000.0
                        convertUnits()
                    })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { oExpanded = true }) { // 드롭다운 표시
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, "")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                        oExpanded = false
                        outputUnit = "Centimeters"
                        oconversionFactor.value = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {
                        oExpanded = false
                        outputUnit = "Meters"
                        oconversionFactor.value = 1.00
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text("Kilometers") }, onClick = {
                        oExpanded = false
                        outputUnit = "Kilometers"
                        oconversionFactor.value = 1.000
                        convertUnits()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result : $outputValue ${outputUnit}")
    }
}