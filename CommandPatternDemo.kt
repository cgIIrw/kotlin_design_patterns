package kotlin_design_patterns

// 命令模式
class Receiver {
    fun rMethod01(name: String) {
        println("方法的名称是：$name")
    }

    fun rMethod02(name: String) {
        println("方法的名称是：$name")
    }
}

class Invoker {
    var command: Command? = null

    constructor(command: Command) {
        this.command = command
    }

    fun invoker() {
        command?.let { it.command01("command01") }

    }
}

class Command() {
    var receiver: Receiver? = Receiver()
    var command01: ((String) -> Unit) = { name -> receiver?.rMethod01(name) }
}

fun main(args: Array<String>) {
    Invoker(Command()).invoker()
}

