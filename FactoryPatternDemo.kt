package kotlin_design_patterns

// 工厂模式实现
interface Product {
    fun printProductId()
}

abstract class Factory {
    fun product(productId: String): Product {
        var p = createProduct(productId)
        return p
    }

    protected abstract fun createProduct(productId: String): Product;
}

class Pen(var productId: String) : Product {
    override fun printProductId() {
        println("该笔的ID是：$productId")
    }
}

object PenFactory : Factory() {
    override fun createProduct(productId: String): Product {
        return Pen(productId)
    }
}

fun main(args: Array<String>) {
    var oneProduct = PenFactory.product("9527")
    oneProduct.printProductId()
}