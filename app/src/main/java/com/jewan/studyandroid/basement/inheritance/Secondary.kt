package com.jewan.studyandroid.basement.inheritance

// 파생 클래스
open class Secondary : BaseClass() { // 상속

    override fun role() {
        super.role() // 부모의 role도 실행
        println("츄르 주기")
    }
}