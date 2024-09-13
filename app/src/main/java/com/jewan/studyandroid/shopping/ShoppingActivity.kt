package com.jewan.studyandroid.shopping

import android.app.AlertDialog
import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


data class ShoppingItem( // 데이터 객체
    val id: Int,
    var name: String,
    var quantitiy: Int,
    var isEditing: Boolean = false
)

@Composable
fun ShoppingListApp() {
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { showDialog = true },
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
            items(sItems) {
                ShoppingListItem(it, {}, {})
            }
        }
    }
    if (showDialog) {
        AlertDialog(onDismissRequest = { showDialog = false },
            confirmButton = { // 확인 버튼 부분을 오버라이드
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        // 비어있지 않다면
                        if (itemName.isNotBlank()) {
                            val newItem = ShoppingItem(
                                id = sItems.size + 1,
                                name = itemName,
                                quantitiy = itemQuantity.toInt()
                            )
                            // 왜 + 연산??
                            // 새로운 리스트를 할당함으로써 컴포저블 재구성(recomposition)이 더 명확하게 발생
                            sItems += newItem
                            showDialog = false
                            itemName = ""
                        }
                    }) { Text("추가") }
                    Button(onClick = { showDialog = false }) { Text("취소") }
                }

            },
            title = { Text("상품 추가") },
            text = {
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = { itemName = it },
                        singleLine = true, // 다중 줄을 허용하지 않음
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = { itemQuantity = it },
                        singleLine = true, // 다중 줄을 허용하지 않음
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            })
    }
}

@Composable
fun ShoppingListItem(
    item: ShoppingItem,
    onEditClick: () -> Unit,    // 수정을 눌렀을 때 사용할 람다
    onDeleteClick: () -> Unit  // 삭제를 눌렀을 때 사용할 람다
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                border = BorderStroke(2.dp, Color.Gray),
                shape = RoundedCornerShape(20) // 모서리 둥근 정도
            )
    ) {
        Text(text = item.name, modifier = Modifier.padding(8.dp))
        Text(text = "수량: ${item.quantitiy}", modifier = Modifier.padding(8.dp))
        Row(Modifier.padding(8.dp)) {
            IconButton(onClick = onEditClick) { // 아이콘 버튼을 만들 수도 있답니다.
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}

@Composable
fun ShoppingItemEditor(item: ShoppingItem, onEditComplete: (String, Int) -> Unit) {
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuality by remember { mutableStateOf(item.quantitiy.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly // 서로 거리가 동일함
    ) {
        Column {
            BasicTextField(
                value = editedName,
                onValueChange = {editedName = it},
                singleLine = true,
                modifier = Modifier.wrapContentSize().padding(8.dp) // 필요한 항목의 크기만 차지
            )
            BasicTextField(
                value = editedQuality,
                onValueChange = {editedQuality = it},
                singleLine = true,
                modifier = Modifier.wrapContentSize().padding(8.dp) // 필요한 항목의 크기만 차지
            )
        }
        Button(onClick = {
            isEditing = false
            onEditComplete(editedName, editedQuality.toIntOrNull() ?: 1)
        }) { Text("저장") }
    }
}