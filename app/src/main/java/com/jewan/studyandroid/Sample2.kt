package com.jewan.studyandroid

fun main() {
    // forAndWhile()
    nullChk()
}

// 5. Array and List
// Array -> 크기가 정해져버림
// List -> MutableList, List
fun array() {

    // 선언 및 초기화
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)

    val array2 = arrayOf(1, "2", 3.4f) // 이런 식으로도 생성 가능
    val list2 = listOf(1, "2", 3, 4f)

    array[0] = 3
    // list[0] = 3 이런 식으로는 변경 불가
    var result = list[0] // 가져오기만 가능
    result = list.get(0)

    val arrayList = arrayListOf(1, 2, 3)
    val arrayList2 = arrayListOf<Int>() // 추론할 수 없을 땐 타입 명시
    arrayList.add(1)
    arrayList.set(0, 2)
    arrayList[0] = 2
}

// 6. 반복문
fun forAndWhile() {
    val students = arrayListOf("Jewan", "Taekbae", "Shopo")
    for (name in students)
        println("${name}")

    var sum = 0
    for (i in 1..10) // include
        sum += i
    println(sum)

    for (i in 1 until 10) // exclude
        sum += i
    println(sum)

    for (i in 1..10 step 2) // 증가하는 값 설정
        sum += i
    println(sum)

    for (i in 10 downTo 1) // 감소
        sum += i
    println(sum)

    // 인덱스를 넣은 for문도 가능
    for ((i, name) in students.withIndex()) // 자동으로 앞 변수에 인덱스를 넣어줌
        println("${i + 1}번 째 학생은 ${name}")

    var idx = 0
    while (idx++ < 10)
        println(idx)
}

// 7. Nullable / NonNull
fun nullChk() {
    // NPE : Null Point Exception -> 자바에서는 런타임 중에서만 확인할 수 있었음
    // 코틀린은 "?" 로 해결
    var name = "Jewan" // NonNull 타입
    var nullName: String? = null // Nullable 타입
    var nullName2 = null // 이렇게도 선언 가능한데

    var nameToUpper = name.toUpperCase() // 이제 이런거 안쓴다고..?
    var nameToUpper2 = name.uppercase()

    var nullNameToUpper = nullName?.uppercase() // Null이 아닌 경우에만 실행
    if (nullName != null)
        nullNameToUpper = nullName.uppercase()  // Null 체크를 미리 했다면 그냥 사용 가능

    // ?:
    var lastName = null
    var fullName = name + " " + (lastName ?: "Baek") // Null일 경우 Default값을 설정 가능
    println(fullName)

    // !!
    // val nullIgnore = name + " " + lastName!!

    // let
    lastName?.let{ // 해당 변수가 Null이 아닐 경우에만 실행
        println(lastName)
    }
}