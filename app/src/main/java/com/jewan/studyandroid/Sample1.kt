package com.jewan.studyandroid

fun main() { // 메인 함수
    helloWorld()
    println(add(4, 5))
    stringTemplate()
}

// 1. 함수 선언
// fun 으로 함수 선언
fun helloWorld(): Unit { // void == Unit 반환형 -> 생략 가능
    println("Hello World!") // 세미클론은 붙이지 않음
}

fun add(a: Int, b: Int): Int { // 매개 변수 설정, 반환 자료형 설정
    return a + b
}

// 2. val vs var
// val -> 값 변경 불가
// var -> 값 변경 가능
fun valvar() {
    val a = 10 // 자료형이 추론 가능한 경우에는 생략 가능
    var b: Int = 10

    // a = 100 -> 직접 변경 불가
    b = 100 // var는 값을 직접 변경 가능

    var name = "Jewan"

    // 변수를 초기화 하지 않는다면 자료형을 명시
    var c: String
}

// 3. String Template
fun stringTemplate() {
    val name = "Jewan"
    println("My name is $name .")
    println("My name is ${name}.") // 붙여서 뭔갈 더 적고 싶다면 괄호로 묶기 or 문자와 구별 가능한 것으로
    println("\$") // 이스케이프 처리
}

// 4. 조건식
// 일반적으로 자바에서 쓰던 조건식
fun maxJava(a: Int, b: Int): Int {
    if (a > b)
        return a
    else
        return b
}

// 코틀린에서는 삼항 연산처럼 사용 가능
fun maxKotiln(a: Int, b: Int) = if (a > b) a else b // 자동 타입 추론으로 반환형은 생략

// when은 자바에서 향상된 switch구문 같네
fun chkNum(score: Int) {
    when (score) {
        0 -> println("0")
        1 -> println("1")
        2, 3 -> println("2 or 3")
        // else -> println("idk") 일반적으로는 생략 가능
    }

    // 변수에 넣어줄 때는 else구문이  필수
    var num = when (score) {
        1 -> 1
        2 -> 10
        3 -> 100
        else -> 0
    }

    when (score) {
        in 0..50 -> println("뭐여.. 이런것도 돼?")
        in 51..100 -> println("VBA가 생각나네")
    }
}