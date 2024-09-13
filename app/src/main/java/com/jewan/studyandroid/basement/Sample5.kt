package com.jewan.studyandroid.basement

// POJO : Plain Old Java Object
// 자바는 다 작성해야 함
// Data Class : 코틀린의 POJO..?
data class Student(val name: String, val age: Int, val birthDay: String, var friend: String)
// 이거 하나로 toString, hashCode, equals, copy 다 만들어짐

class Teacher(val name: String, val age: Int, val birthDay: String, var friend: String)

fun main() {
    val jewan = Student("Jewan", 5, "1120", "Taekbae")
    val taekbae = Teacher("Taekbae", 2, "0815", "Jewan")

    println(jewan) //    Student(name=Jewan, age=5, birthDay=1120, friend=Taekbae) -> toString
    println(taekbae) //    com.jewan.studyandroid.Teacher@7291c18f
}