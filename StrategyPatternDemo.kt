package kotlin_design_patterns

import java.lang.IllegalArgumentException

// 策略模式

interface Strategy {
    fun algori(num01: Double, num02: Double): Double
}

class `加` : Strategy {
    override fun algori(num01: Double, num02: Double): Double {
        return num01 + num02
    }
}

class `减` : Strategy {
    override fun algori(num01: Double, num02: Double): Double {
        return num01 - num02
    }
}

class `乘` : Strategy {
    override fun algori(num01: Double, num02: Double): Double {
        return num01 * num02
    }
}

class `除` : Strategy {
    override fun algori(num01: Double, num02: Double): Double {
        if (num02.equals(0.0)) {
            throw IllegalArgumentException("错误的被除数输入！")
        }
        return num01 / num02
    }
}

class StrategyContext(var strategy: Strategy) {
    fun operator(num01: Double, num02: Double): Double {
        return strategy.algori(num01, num02)
    }
}

fun main(args: Array<String>) {
    // 计算除法
    var context = StrategyContext(`除`())
    println(context.operator(5.0, 0.0))
}