package kotlin_design_patterns

// 外观模式
class A {
    init {
        println("我是A！")
    }
}

class B
class C

class Facade {
    var a: A? = null
    var b: B? = null
    var c: C? = null
    fun facadeMethod() {
        a = A()
        b = B()
        c = C()
    }
}

fun main(args: Array<String>) {
    var facade = Facade()
    facade.facadeMethod()
    facade.a
}