package GUISamples.features.cropper

import GUISamples.utils.canvasToImage
import GUISamples.utils.setImageIntoCanvas
import javafx.scene.canvas.Canvas
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

class createSupperCropperRectangle(val canvas: Canvas) {
    val rectangle = Rectangle(0.0, 0.0, Color.rgb(0, 0, 0, 0.5))
    var activeCrop = false

    var initX = 0.0
    var initY = 0.0

    fun startCrop(e: MouseEvent, cb: (() -> Unit)?) {
        if (e.button == MouseButton.SECONDARY) {
            rectangle.x = e.x
            rectangle.y = e.y
            activeCrop = true
            initX = e.x
            initY = e.y
            if (cb != null) cb()
        }
    }

    fun endCrop(e: MouseEvent, cb: (() -> Unit)?) {
        if (e.button == MouseButton.SECONDARY) {
            activeCrop = false
            setImageIntoCanvas(canvasToImage(canvas, rectangle), canvas)
            if (cb != null) cb()
            rectangle.x = 0.0
            rectangle.y = 0.0
            rectangle.width = 0.0
            rectangle.height = 0.0

        }
    }

    fun setOffset(e: MouseEvent) {
        if (activeCrop) {
            val offsetX: Double = e.x - initX
            val offsetY: Double = e.y - initY

            if (offsetX > 0) {
                rectangle.width = offsetX
            } else {
                rectangle.x = e.x
                rectangle.width = initX - rectangle.x
            }

            if (offsetY > 0) {
                rectangle.height = offsetY
            } else {
                rectangle.y = e.y
                rectangle.height = initY - rectangle.y
            }

        }
    }
}