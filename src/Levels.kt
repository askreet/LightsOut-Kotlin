object BoardLevels {
    private var LEVELS = arrayOf(
        listOf( Pair(1, 1), Pair(1, 2), Pair(5, 5), Pair(5, 4) ),
        listOf( Pair(1, 1), Pair(2, 2), Pair(3, 3), Pair(4, 4), Pair(5, 5) )
    )

    fun applyLevelToBoard(level: Int, board: Board) {
        val steps: List<Pair<Int, Int>> = LEVELS[level]

        for ((x, y) in steps) {
            board.press(x, y)
        }
    }
}