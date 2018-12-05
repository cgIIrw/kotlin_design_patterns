package kotlin_design_patterns

// 状态模式
internal abstract class State {
    abstract fun addContext(context: Context)

    override fun toString(): String {
        return this.javaClass.simpleName
    }
}

internal class Context {
    var state: State? = null
}

internal class StartState : State() {
    override fun addContext(context: Context) {
        println("打印开始状态名：")
        context.state = this
    }
}

internal class StopState : State() {
    override fun addContext(context: Context) {
        println("打印停止状态名：")
        context.state = this
    }
}

fun main(args: Array<String>) {
    var context = Context()
    StartState().addContext(context)
    println(context.state)
    StopState().addContext(context)
    println(context.state)
}