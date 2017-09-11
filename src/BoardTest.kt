import org.junit.Test
import org.junit.Assert.*

const val T = true
const val F = false

class BoardTest {
    @Test
    fun testInitialBoardIsDark() {
        val board = Board()

        assertArrayEquals(
                arrayOf(F, F, F, F, F,
                        F, F, F, F, F,
                        F, F, F, F, F,
                        F, F, F, F, F,
                        F, F, F, F, F),
                board.asArray()
        )
    }

    @Test
    fun testPressScenarios() {
        val board = Board()

        board.press(1, 1)

        assertArrayEquals(
                arrayOf(T, T, F, F, F,
                        T, F, F, F, F,
                        F, F, F, F, F,
                        F, F, F, F, F,
                        F, F, F, F, F),
                board.asArray()
        )

        board.press(3, 1)

        assertArrayEquals(
                arrayOf(T, F, T, T, F,
                        T, F, T, F, F,
                        F, F, F, F, F,
                        F, F, F, F, F,
                        F, F, F, F, F),
                board.asArray()
        )

        board.press(5, 5)

        assertArrayEquals(
                arrayOf(T, F, T, T, F,
                        T, F, T, F, F,
                        F, F, F, F, F,
                        F, F, F, F, T,
                        F, F, F, T, T),
                board.asArray()
        )
    }

    @Test
    fun testRefusesInvalidValues() {
        val board = Board()

        val badCalls = listOf(
                { board.press(0, 1) },
                { board.press(6, 1) },
                { board.press(1, 0) },
                { board.press(1, 6) }
        )

        for (call in badCalls)
            assertThrows(AssertionError::class.java, call)
    }

    @Test
    fun testButtons() {
        val board = Board()

        val buttons = board.buttons()

        var expectedX = 1
        var expectedY = 1

        for (button in buttons) {
            assertEquals(expectedX, button.x)
            assertEquals(expectedY, button.y)

            expectedX++
            if (expectedX > 5) {
                expectedX = 1
                expectedY++
            }
        }
    }
}