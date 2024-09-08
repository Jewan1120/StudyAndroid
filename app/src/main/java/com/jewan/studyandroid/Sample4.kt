package com.jewan.studyandroid

fun main() {
    println(square(4))
    println(pow(5))
    println(nameAge) // 그냥 호출도 가능하네
    println(nameAge("Jewan", 2))
    println("배고파 ".hungry()) // 오 이런 식으로 확장 가능
    println(extendString("Taekbae", 1))
    println(calculateFriend(1001))

    val lamda = { number: Double -> number == 4.123 }
    println(invokeLamda(lamda))
    println(invokeLamda({ it < 3.123 })) // 마지막 파라미터가 람다일 때 가능
    invokeLamda { it < 3.123 }
    invokeLamda(){it < 3.123} // 이것도 가능
}

// 1. Lamda
// value처럼 다룰 수 있는 익명 함수
// 1) 매서드에 파라미터로 넘겨줄 수 있음
// 2) return 값으로 사용할 수 있음.

// 정의
// val lamdaName : Type = {argumentList -> codeBody}
val square: (Int) -> (Int) = { number -> number * number } // 함수를 변수처럼 저장, 자바에서 사용했던 방식

// ((o1, o2) -> o1 - o2)
val pow = { number: Int -> number * number } // 이런 식으로도 저장 가능

val nameAge = { name: String, age: Int ->
    "My name is ${name} And My age is ${age}"
}

// 2. 확장 함수
val hungry: String.() -> String = { // 해당 String을 this로 가져옴
    this + "밥 줘"
}

fun extendString(name: String, age: Int): String {
    val introduceMyself: String.(Int) -> String =
        { "I am ${this} and ${it} years old" } // this와 it, it은 인자로 들어온 값이 1개일 때
    return name.introduceMyself(age)
}

// 3. 람다의 return
val calculateFriend: (Int) -> String = {
    when (it) {
        in 0..40 -> "Jewan"
        in 41..70 -> "Taekbae"
        in 71..100 -> "Shopo"
        else -> "Doldol"
    }
}

// 4. 람다를 표현하는 방식
fun invokeLamda(lamda: (Double) -> Boolean): Boolean {
    return lamda(1.234)
}