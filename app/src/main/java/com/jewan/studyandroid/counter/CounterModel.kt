package com.jewan.studyandroid.counter

// Model은 data class
data class CounterModel(var count: Int)

// Repository
class CounterRepository {
    private var _counter = CounterModel(0)

    fun getCounter() = _counter
    fun incrementCounter() = _counter.count++
    fun decrementCoutner() = _counter.count--

}