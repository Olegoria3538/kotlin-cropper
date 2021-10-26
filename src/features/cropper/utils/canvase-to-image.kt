package GUISamples.utils

import javafx.geometry.Rectangle2D
import javafx.scene.SnapshotParameters
import javafx.scene.canvas.Canvas
import javafx.scene.image.WritableImage
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle



fun canvasToImage(canvas: Canvas, rectangle: Rectangle?): WritableImage {
    val parameters = SnapshotParameters()
    parameters.setFill(Color.TRANSPARENT)
    var width = canvas.width.toInt()
    var height = canvas.height.toInt()
    if (rectangle != null) {
        val bounds = rectangle.getBoundsInParent()
        parameters.viewport = Rectangle2D(bounds.getMinX(), bounds.getMinY(), bounds.width, bounds.height)
        width = bounds.width.toInt()
        height = bounds.height.toInt()
    }
    val wim = WritableImage(width, height)
    canvas.snapshot(parameters, wim);
    return wim
}
