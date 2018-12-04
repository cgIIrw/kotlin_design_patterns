package kotlin_design_patterns


// 职责链模式
interface Thing {}

class Apple : Thing {}

class Orange : Thing {}

abstract class Member(open var name: String) {
    var next: Member? = null

    fun doThing(thing: Thing) {
        if (resolve(thing)) {
            done(thing);
        } else {
            next?.doThing(thing)?: fail(thing)
        }
    }

    abstract fun resolve(thing: Thing): Boolean
    protected fun done(thing: Thing) {
        println("被${this}吃掉")
    }

    protected fun fail(thing: Thing) {
        println("不能被吃掉")
    }

    override fun toString(): String {
        return "[${name}]"
    }
}

class Child(override var name: String): Member(name) {
    override fun resolve(thing: Thing): Boolean {
        return false
    }
}

class Mom(override var name: String) : Member(name) {
    override fun resolve(thing: Thing): Boolean {
        if (thing is Apple)
            return true
        return false
    }
}

class Father(override var name: String) : Member(name) {
    override fun resolve(thing: Thing): Boolean {
        return true
    }
}

fun main(args: Array<String>) {
    var child = Child("小宝贝")
    child.next = Mom("妈妈")
    child.next?.next = Father("爸爸")
    child.doThing(Orange())
}