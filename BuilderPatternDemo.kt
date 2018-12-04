package kotlin_design_patterns

// 建造者模式
class BuilderProduct {
    val color: String?
    val id: Int
    val size: Int

    companion object Builder {
        private var color: String? = null
        private var id: Int = 0
        private var size: Int = 0

        fun builderColor(color: String): Builder {
            this.color = color
            return this
        }

        fun builderId(id: Int): Builder {
            this.id = id
            return this
        }

        fun builderSize(size: Int): Builder {
            this.size = size
            return this
        }

        fun build(): BuilderProduct {
            return BuilderProduct(this)
        }
    }

    private constructor(builder: Builder) {
        this.color = builder.color
        this.id = builder.id
        this.size = builder.size
    }
}

fun main(args: Array<String>) {
    var builderProduct = BuilderProduct.Builder.builderColor("Red")
        .builderId(1).builderSize(5000).build()
    println(builderProduct.size)
}