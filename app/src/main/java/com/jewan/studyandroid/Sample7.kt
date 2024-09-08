package com.jewan.studyandroid

data class Car(val horsePower: Int)

// 애플리케이션이 실행되면 단 하나만 생성 -> SingleTon
object CarFactory {
    var cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int): Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

fun main() {
    val carA = CarFactory.makeCar(100)
    val carB = CarFactory.makeCar(10)
    println("현재 만들어진 자동차 수 : ${CarFactory.cars.size}")
}
