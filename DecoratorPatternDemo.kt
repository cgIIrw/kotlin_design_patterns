package kotlin_design_patterns

// 装饰器模式
interface DecComponent {
    fun DecPrint()
}

class ConcreteComponent : DecComponent {
    override fun DecPrint() {
        println("我是被装饰的对象！")
    }
}

abstract class Decorator(open var decComponent: DecComponent) : DecComponent {}

class ConcreteDecorator(override var decComponent: DecComponent) : Decorator(decComponent) {
    override fun DecPrint() {
        println("－－－－－我是装饰物－－－－－")
        decComponent.DecPrint()
        println("－－－－－我是装饰物－－－－－")
    }
}

fun main(args: Array<String>) {
    var c = ConcreteComponent()
    var decorator = ConcreteDecorator(c)
    decorator.DecPrint()
}
