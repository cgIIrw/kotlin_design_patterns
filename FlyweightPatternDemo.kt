package kotlin_design_patterns


// 享元模式
interface FruitFlyweight {
    fun printColor()
}

class OrangeFlyweight(var color: String) : FruitFlyweight {

    override fun printColor() {
        println("$color $this")
    }
}

class FruitFactoryFlayweight {
    companion object {
        val fruitMap = HashMap<String, FruitFlyweight>()
        fun getFruitflyweight(color: String): FruitFlyweight {
            var flyweight = fruitMap[color]
            flyweight = flyweight ?: OrangeFlyweight(color)
            fruitMap.put(color, flyweight)
            return flyweight
        }
    }
}

fun main(args: Array<String>) {
    FruitFactoryFlayweight.getFruitflyweight("Red").printColor()
    FruitFactoryFlayweight.getFruitflyweight("Red").printColor()
}