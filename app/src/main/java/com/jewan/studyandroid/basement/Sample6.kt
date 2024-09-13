package com.jewan.studyandroid.basement

class Book private constructor(val id: Int, val name: String) { // 이런 식으로 다른 곳에서는 가져다 쓸 수 없게 만들 수 있음
    // JAVA의 static이라 생각하면 됨
    companion object BookFactory : IdProvider { // 오브젝트에 이름도 붙일 수 있음
        var bookIdx = 0
        override fun getId() = ++bookIdx
        fun create() = Book(getId(), "고양이랑 친해지기")
    }
}

interface IdProvider {
    fun getId() : Int
}

fun main() {
    val bookA = Book.create() // 이런 식으로 접근해야 함
    val bookB = Book.create() // 오브젝트에 이름이 있을 경우 지정 가능
    println(bookA)
    println("${bookA.id}번 책 ${bookA.name}")
    println("${bookB.id}번 책 ${bookB.name}")
}