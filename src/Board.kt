data class Button(val x: Int, val y: Int, val state: Boolean)

class Board {
    private val grid = Array(25, { false })

    fun press(x: Int, y: Int) {
        flip(x, y)
        if (x > 1) flip(x - 1, y)
        if (x < 5) flip(x + 1, y)
        if (y > 1) flip(x, y - 1)
        if (y < 5) flip(x, y + 1)
    }

    fun asArray() = grid.clone()

    fun buttons(): List<Button> = grid.withIndex().map { (index, state) ->
        val x = (index % 5) + 1
        val y = (index / 5) + 1
        Button(x, y, state)
    }

    private fun flip(x: Int, y: Int) {
        assert(x in 1..5)
        assert(y in 1..5)

        val pos = ((y-1)*5)+(x-1)
        grid[pos] = !grid[pos]
    }
}
