package kotlin_design_patterns

// 抽象工厂模式实现
interface ProductA {
    fun printProductId()
}

interface ProductB {
    fun printProductId()
}

abstract class AbstractFactory {
    var producta: ProductA? = null
    var productb: ProductB? = null

    fun product(id01: String?, id02: String?) {
        producta = createProductA(id01)
        productb = createProductB(id02)
    }

    abstract fun createProductA(id: String?): ProductA
    abstract fun createProductB(id: String?): ProductB
}

class CompA_ProductA(var id: String?) : ProductA {
    override fun printProductId() {
        id?.let { println("组合A的产品A的ID是：$it") }
            ?: println("没有生产组合A的产品A")
    }
}

class CompA_ProductB(var id: String?) : ProductB {
    override fun printProductId() {
        id?.let { println("组合A的产品B的ID是：$it") }
            ?: println("没有生产组合A的产品B")
    }
}

class CompB_ProductA(var id: String) : ProductA {
    override fun printProductId() {
        println("组合B的产品A的ID是：$id")
    }
}

class CompB_ProductB(var id: String) : ProductB {
    override fun printProductId() {
        println("组合B的产品B的ID是：$id")
    }
}

class CompAFactory(id01: String?, id02: String?) : AbstractFactory() {
    init {
        super.product(id01, id02)
    }

    override fun createProductA(id: String?): ProductA {
        return CompA_ProductA(id)
    }

    override fun createProductB(id: String?): ProductB {
        return CompA_ProductB(id)
    }
}

fun main(args: Array<String>) {
    var compAFactory = CompAFactory("01", null)
    var compA_ProductA = compAFactory.producta
    var compA_ProductB = compAFactory.productb
    compA_ProductA?.printProductId()
    compA_ProductB?.printProductId()
}