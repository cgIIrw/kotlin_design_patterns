package kotlin_design_patterns

// 迭代器模式
interface Iterator {
    fun next(): Any
    fun hasNext(): Boolean
}

class ImlIterator(var imlIteratorProduct: ImlIteratorProduct) : Iterator {
    var index: Int = 0

    override fun next(): Any {
        var s = imlIteratorProduct.arr[index]
        index++
        return s
    }

    override fun hasNext(): Boolean {
        if (index < imlIteratorProduct.arr.size)
            return true
        return false
    }
}

interface IteratorProduct {
    fun iterator(): Iterator
}

class ImlIteratorProduct : IteratorProduct {
    var arr = arrayListOf<Any>("chenchen", "guoguo", "nini", "haohao")


    override fun iterator(): Iterator {
        return ImlIterator(this)
    }
}

fun main(args: Array<String>) {
    var imlIteratorProduct = ImlIteratorProduct()
    var iter = imlIteratorProduct.iterator()
    while (iter.hasNext()) {
        println(iter.next() as String)
    }
}