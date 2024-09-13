package com.jewan.studyandroid.basement

class People constructor(val name: String) { // 생성자 생략 가능, val 생략 가능
    val friend = name
    val friend2 = "Shopo"
    fun eat() = println("Yum")
}

class SimplePeople(friend: String = "Nobody") {
}

// 초기화 시 실행할 명령 -> Init이 가장 먼저 실행됨. Constructor보다 먼저임
class InitPeople() {
    init {
        println("초기화 했음")
    }
}

// 생성자 오버로드
class ConstructorPeople(name: String) {
    constructor(name: String, age: Int) : this(name) { // 추가적으로 생성자를 오버로드 하려면 this를 기재
    }
}

// 상속
// open으로 접근할 수 있게 해줘야 함
open class Animal() {
    open fun move() = println("걷기") // 오버 라이드 시킬려고 해도 open
}
class Cat : Animal() {
    override fun move() = println("누워버리기")
}

fun main() {
    var jewan = People("Taekbae")
    jewan.eat()
    println("Jewan's Friend ${jewan.friend}")
    println("Jewan's Friend ${jewan.friend2}")

    var jewan2 = SimplePeople()
    var jewan3 = SimplePeople("Taekbae")

    var initPeople = InitPeople() // init 실행
}