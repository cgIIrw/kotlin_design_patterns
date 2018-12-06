package kotlin_design_patterns

// 访问者模式
abstract class Element(open var name: String) {
    fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class Element01(override var name : String) : Element(name)

class Visitor {
    fun visit(element: Element) {
        println("被访问者的名字是：${element.name}")
    }
}

fun main(args: Array<String>) {
    var visitor = Visitor()
    var element01 = Element01("Element01")
    element01.accept(visitor)
}