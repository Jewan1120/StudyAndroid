package com.jewan.studyandroid.basement.inheritance

// 부모 클래스가 되기 위해선 open
open class BaseClass {

    fun coreVales() = println("택배 쓰다듬기")

    // 오버라이드하기 위한 open
    open fun role() = println("캔 따개")
}