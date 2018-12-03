package kotlin_design_patterns

// 适配器模式实现
interface Target {
    fun targetMathod()
}

class Adaptee {
    fun adapteeMethod() {
        println("我是adaptee！")
    }
}

class Adapter(var adaptee: Adaptee) : Target{
    override fun targetMathod() {
        adaptee.adapteeMethod()
    }
}

fun main(args: Array<String>) {
    var ada = Adapter(Adaptee()) as Target
    ada.targetMathod()
}