package kotlin_design_patterns

// 模版方法模式
abstract class AbstractClass {
    abstract fun doThing01()
    abstract fun doThing02()

    fun display() {
        doThing01()
        doThing02()
    }
}

class ConcreteClass : AbstractClass() {
    override fun doThing01() {
        println("我是doThing01！")
    }

    override fun doThing02() {
        println("我是doThing02！")
    }

}

fun main(args: Array<String>) {
    var concreteClass = ConcreteClass()
    concreteClass.display()
}