import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.TilePane

class ButtonGridScene(private val board: Board, width: Double, height: Double) : Scene(TilePane(), width, height) {
    companion object {
        const val WIDTH = 300.0
        const val HEIGHT = 300.0
    }

    private val sceneButtons: HashMap<Pair<Int, Int>, Button> = HashMap()

    init {
        for ((x, y) in board.buttons()) {
            val index = Pair(x, y)

            sceneButtons[index] = makeButton(x, y)
            (root as TilePane).children.add(sceneButtons[index])
        }

        root.stylesheets.add("stylesheet.css")

        updateButtons()
    }

    private fun makeButton(x: Int, y: Int): Button {
        val btn = Button()

        btn.onAction = EventHandler {
            println("x=$x y=$y pressed!")

            board.press(x, y)

            updateButtons()
        }
        btn.setPrefSize(WIDTH / 5, HEIGHT / 5)

        return btn
    }

    private fun updateButtons() {
        for ((x, y, state) in board.buttons()) {
            val style = sceneButtons[Pair(x, y)]!!.styleClass
            style.removeAll()

            val targetStyle = styleForState(state)
            style.setAll(targetStyle)
        }
    }

    private fun styleForState(state: Boolean) = if (state) "button-on" else "button-off"
}
