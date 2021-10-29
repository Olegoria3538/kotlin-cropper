package GUISamples

import GUISamples.features.main.mainWindow
import javafx.application.Application
import javafx.stage.Stage


class Screenshot : Application() {
    override fun start(lol: Stage) {
        mainWindow()
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(Screenshot::class.java)
        }
    }
}