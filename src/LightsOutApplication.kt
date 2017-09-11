import javafx.application.Application
import javafx.stage.Stage

class LightsOutApplication : Application() {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            launch(LightsOutApplication::class.java, *args)
        }
    }

    private val board = Board()

    override fun start(primaryStage: Stage) {
        BoardLevels.applyLevelToBoard(1, board)

        primaryStage.title = "LightsOut in Kotlin with JavaFX"
        primaryStage.scene = ButtonGridScene(board, 300.0, 300.0)
        primaryStage.isResizable = false
        primaryStage.show()
    }
}
