package kotlin_design_patterns

// 原型模式
open class Fruitprototype : Cloneable

class FruitImpl : Fruitprototype {
    var name: String?
    var orange: Orangeprototype?

    constructor(name: String, orange: Orangeprototype) {
        this.name = name
        this.orange = orange
    }

    fun getClone(): FruitImpl? {
        var fruit: FruitImpl? = null
        try {
            fruit = super.clone() as FruitImpl
            // 对内部引用对象进行拷贝操作
            fruit.orange = this.orange?.getClone()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return fruit
    }
}

class Orangeprototype : Fruitprototype {
    var name: String?
    var id: Int?

    constructor(name: String, id: Int) {
        this.name = name
        this.id = id
    }

    fun getClone(): Orangeprototype? {
        var orange: Orangeprototype? = null

        try {
            orange = super.clone() as Orangeprototype
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return orange
    }
}

fun main(args: Array<String>) {
    val orange01 = Orangeprototype("orange01", 1)
    val fruit01 = FruitImpl("fruit01", orange01)
    val fruit02 = fruit01.getClone()
    (fruit02 as FruitImpl).orange?.let { it.id = 2 }
    fruit02.orange?.let { it.name = "orange02" }
    println(orange01.id.toString() + " " + orange01.name)
}