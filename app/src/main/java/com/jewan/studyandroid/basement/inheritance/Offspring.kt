package com.jewan.studyandroid.basement.inheritance

class Offspring : Secondary(), CanOpener, Singer { // 인터페이스 여러 개 상속받기
    // 인터페이스를 사용하려면 구현해야 함
    override fun canOpener() {
        super.canOpener()
        println("내가 먹어버리기")
    }

    override fun sing() {
        super.sing()
        println("냥뇽녕냥")
    }
}