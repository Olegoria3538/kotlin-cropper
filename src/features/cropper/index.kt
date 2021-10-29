package GUISamples

import GUISamples.features.cropper.createMenu
import GUISamples.features.cropper.createSupperCropperRectangle
import GUISamples.features.cropper.utils.quicksaveCanvas
import GUISamples.features.cropper.utils.saveCanvas
import GUISamples.utils.setImageIntoCanvas
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.image.Image
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.stage.Stage
import java.awt.Toolkit


val size = Toolkit.getDefaultToolkit().screenSize

fun Cropper(image: Image) {
    val window = Stage()
    val root = Pane()
    val scene = Scene(root, size.width.toDouble(), size.height.toDouble())
    val canvas = Canvas()
    canvas.width = scene.width
    canvas.height = scene.height


    val pressedKeys = HashSet<KeyCode>()
    scene.onKeyPressed = EventHandler { e: KeyEvent ->
        pressedKeys.add(
            e.code
        )
        if (pressedKeys.contains(KeyCode.CONTROL)) {
            if (pressedKeys.contains(KeyCode.S))
                saveCanvas(canvas)
            if(pressedKeys.contains(KeyCode.Q))
                quicksaveCanvas(canvas)
        }
    }
    scene.onKeyReleased = EventHandler { e: KeyEvent ->
        pressedKeys.remove(
            e.code
        )
    }


    val cropRectangle = createSupperCropperRectangle(canvas)
    val menu = createMenu(canvas)

    val g = canvas.graphicsContext2D


    canvas.onMouseDragged = EventHandler<MouseEvent> { e ->
        val size = menu.getSizeBrash()
        val x = e.x - size / 2
        val y = e.y - size / 2

        if (e.button == MouseButton.PRIMARY) {
            if (!menu.getCheckClear()) {
                g.fill = menu.getColorBrash()
                g.fillRect(x, y, size, size)
            } else {
                g.clearRect(x, y, size, size);
            }
        } else {
            cropRectangle.setOffset(e)
        }
    }

    canvas.onMousePressed = EventHandler<MouseEvent> { e ->
        cropRectangle.startCrop(e, null)
    }

    canvas.onMouseReleased = EventHandler<MouseEvent> { e ->
        cropRectangle.endCrop(e, null)
    }

    root.children.addAll(canvas, cropRectangle.rectangle, menu.menuBar)

    setImageIntoCanvas(image, canvas)

    window.title = "Paint"
    window.setScene(scene)
    window.show()
}




