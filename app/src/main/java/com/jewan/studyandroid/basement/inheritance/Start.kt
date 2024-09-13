package com.jewan.studyandroid.basement.inheritance

fun main() {
    val obj1 = BaseClass()
    obj1.coreVales()

    val obj2 = Secondary()
    obj2.coreVales() // 위와 동일하게 출력 -> 상속받았으니깐.
    obj2.role() // 부모와 자식의 role을 둘다 출력

    val obj3 = Tertiary()
    obj3.role()

    println("제완이 일한다")
    var jewan = Offspring()
    jewan.canOpener()
    jewan.role()
    jewan.coreVales()
    jewan.sing()
}