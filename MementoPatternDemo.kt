package kotlin_design_patterns

// 备忘录模式

class Memento(var state: String?)

class Originator {
    var state: String? = null

    fun saveState(): Memento {
        return Memento(state)
    }

    fun restoreState(memento: Memento) {
        this.state = memento.state
    }
}

class CareTaker {
    private var list = ArrayList<Memento>()

    fun add(memento: Memento) {
        list.add(memento)
    }

    fun get(index: Int): Memento {
        return list[index]
    }
}

fun main(args: Array<String>) {
    var originator = Originator()
    var careTaker = CareTaker()

    originator.state = "存档01"
    careTaker.add(originator.saveState())
    originator.state = "存档02"

    println("当前存档：${originator.state}")
    originator.restoreState(careTaker.get(0))
    println("当前存档：${originator.state}")
}
