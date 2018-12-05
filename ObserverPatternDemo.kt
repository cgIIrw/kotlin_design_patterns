package kotlin_design_patterns

import java.util.ArrayList
// 观察者模式

// 被观察者
internal interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObserver()
}

// 具体被观察者
internal class ConcreteSubject : Subject {
    private val cs: ArrayList<Observer> = ArrayList()
    private var `when`: String? = null
    private var where: String? = null
    private var what: String? = null

    override fun registerObserver(o: Observer) {
        cs.add(o)
    }

    override fun removeObserver(o: Observer) {
        val i = cs.indexOf(o)
        if (i >= 0) {
            cs.removeAt(i)
        }
    }

    override fun notifyObserver() {
        for (i in cs.indices) {
            val o = cs[i]
            o.update(`when`, where, what)
        }
    }

    fun reSetData(`when`: String?, where: String?, what: String?) {
        this.`when` = `when`
        this.where = where
        this.what = what
        notifyObserver()
    }
}

// 观察者
internal interface Observer {
    fun update(`when`: String?, where: String?, what: String?)
}

// 具体观察者
internal class ConcreteObserver : Observer, Message {
    private var `when`: String? = null
    private var where: String? = null
    private var what: String? = null
    private var subject: Subject?

    constructor(subject: Subject?) {
        this.subject = subject
        subject?.registerObserver(this)
    }

    override fun update(`when`: String?, where: String?, what: String?) {
        this.`when` = `when`
        this.where = where
        this.what = what
        message()
    }

    override fun message() {
        println("收到订阅通知：\n时间：$`when`\n地点：$where\n事件：$what")
    }
}

internal interface Message {
    fun message()
}

fun main(args: Array<String>) {
    var s = ConcreteSubject()
    var o = ConcreteObserver(s)
    s.reSetData("早上十点", "叙利亚", "停战")
}