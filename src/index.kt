package GUISamples

import GUISamples.utils.getScreenshot
import javafx.animation.PauseTransition
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.Slider
import javafx.scene.layout.VBox
import javafx.stage.Stage
import javafx.util.Duration


class Screenshot : Application() {
    override fun start(primaryStage: Stage) {
        val window = Stage()
        var takeScreenshot = Button("Screenshot")
        val slider = Slider(0.0, 10.0, 0.0)
        val checkBox = CheckBox("minimazed")

        val root = VBox()

        takeScreenshot.onAction = EventHandler {
            if (checkBox.isSelected) {
                window.opacity = 0.0
                window.isIconified = true
            }
            val pause = PauseTransition(Duration.seconds(slider.value + 0.1))
            pause.onFinished = EventHandler {
                val image = getScreenshot()
                Cropper(image)
                window.opacity = 1.0
            }
            pause.play();
        }


        root.children.addAll(takeScreenshot, slider, checkBox)

        //создаем окно
        val scene = Scene(root, 500.0, 450.0)

        window.title = "Paint"
        window.setScene(scene)
        window.show()
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(Screenshot::class.java)
        }
    }
}