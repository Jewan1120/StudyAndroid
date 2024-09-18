package com.jewan.studyandroid.counter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() { // 뷰 모델 구현
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count) // 변수 앞에 _를 붙임으로서 private임을 알림 -> 관습
    // 가변 상태이지만 외부에 노출할 때는 불변 상태로 노출해야 함
    val count : MutableState<Int> = _count

    // 클래스 파일 내부에서만 값 변경 가능하도록
    // Model에 접근하여 값을 바꿔줌
    fun increment() {
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }
    fun decrement(){
        _repository.decrementCoutner()
        _count.value = _repository.getCounter().count
    }
}
// M : 따로 구현해야 하는 데이터 모델
// V : MainActivity
// VM : 현재 이 뷰와 모델 사이에 존재하는 녀석