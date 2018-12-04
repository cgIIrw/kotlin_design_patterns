package kotlin_design_patterns

// 代理模式
interface Proxy {
    fun doSomething()
}

class ProxyIml : Proxy {
    override fun doSomething() {
        println("我是被代理的对象！")
    }
}

class RealProxy(var proxy: Proxy = ProxyIml()) : Proxy {

    override fun doSomething() {
        println("我是代理人！")
        proxy.doSomething()
    }
}

fun main(args: Array<String>) {
    RealProxy().doSomething()
}