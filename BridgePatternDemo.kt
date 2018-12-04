package kotlin_design_patterns

// 桥接模式
interface Student {
    fun study()
    fun sleep()
}

// 学生的具体实现
class ChinaStudent: Student {
    override fun study() {
        println("非常努力！")
    }

    override fun sleep() {
        println("没有时间休息！")
    }
}

// 学生参加课外活动功能扩展
open class Activities(private var student: Student) {
    fun study() {
        student.study()
    }

    fun sleep() {
        student.sleep()
    }
}

class ExActivities(var student: Student) : Activities(student) {
    fun exActivity() {
        if (student is ChinaStudent)
            println("中国学生太累不参加活动！")
    }
}

fun main(args: Array<String>) {
    ExActivities(ChinaStudent()).exActivity()
}