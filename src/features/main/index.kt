package GUISamples.features.main

import GUISamples.Cropper
import GUISamples.features.cropper.utils.openImage
import GUISamples.features.main.utils.getLastSavePath
import GUISamples.utils.getScreenshot
import javafx.animation.PauseTransition
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.Slider
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.HBox
import javafx.stage.Stage
import javafx.util.Duration

fun mainWindow() {
    val window = Stage()
    val takeScreenshotBtn = Button("Клик")
    val openImageBtn = Button("Открыть")
    val slider = Slider(0.0, 10.0, 0.0)
    val checkBox = CheckBox("Скрыть")

    val root = HBox()
    root.padding = Insets(10.0)
    slider.padding = Insets(0.0, 10.0, 0.0, 10.0)

    fun takeScreenshot() {
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

    takeScreenshotBtn.onAction = EventHandler {
        takeScreenshot()
    }

    openImageBtn.onAction = EventHandler {
        val img = openImage()
        if (img != null) Cropper(img)
    }


    val pathLastSave = getLastSavePath()
    if (pathLastSave != null) {
        val openLastImage = Button("Последнее сохранненое")
        openLastImage.onAction = EventHandler {
            val img = openImage(pathLastSave)
            if (img != null) Cropper(img)
        }
        root.children.add(openLastImage)
    }

    root.children.addAll(openImageBtn, takeScreenshotBtn, slider, checkBox)
    val scene = Scene(root, if (pathLastSave == null) 400.0 else 550.0, 50.0)

    scene.onKeyPressed = EventHandler { e: KeyEvent ->
        if (e.code == KeyCode.F) takeScreenshot()
    }

    window.title = "SUPER SCREENSHOT"
    window.setScene(scene)
    window.show()
}