package kotlin_design_patterns

// 中介者模式
class AA(var name: String) {
    fun doSomething(mediator: Mediator) {
        mediator.aMethod()
    }
}

class BB(var name: String) {
    fun doSomething(mediator: Mediator) {
        mediator.bMethod()
    }
}

class Mediator {
    var a: AA
    var b: BB

    constructor(a: AA, b: BB) {
        this.a = a
        this.b = b
    }

    fun aMethod() {
        println("${a.name} 在前，${b.name} 在后。")

    }

    fun bMethod() {
        println("${b.name} 在前，${a.name} 在后。")
    }
}

fun main(args: Array<String>) {
    var a = AA("小A")
    var b = BB("小B")
    var mediator = Mediator(a, b)

    a.doSomething(mediator)
    b.doSomething(mediator)
}