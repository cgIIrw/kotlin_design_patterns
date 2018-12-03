package kotlin_design_patterns

// 组合模式
abstract class Component(open var size: Int) {
    abstract fun getId(): String

    override fun toString(): String {
        return "${getId()}大小为：${size}"
    }
}

class Leaf(val id: Int, override var size: Int) : Component(size) {
    override fun getId(): String {
        return "ID是${id}的Leaf"
    }
}

class Composite(val id: Int, override var size: Int = 0) : Component(size) {
    var composite = ArrayList<Component>()
    override fun getId(): String {
        return "ID是${id}的Composite"
    }

    fun add(e: Component) {
        composite.add(e)
        size = composite.size
    }
}

fun main(args: Array<String>) {
    var component01 = Composite(1)
    var component02 = Composite(2)
    var component03 = Composite(3)
    var component04 = Composite(4)

    component01.add(component02)
    component02.add(component03)
    component02.add(component04)
    component02.add(Leaf(11, 100))
    println(component01)
    println(component02)
}