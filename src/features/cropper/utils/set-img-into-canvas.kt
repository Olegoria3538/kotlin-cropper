package GUISamples.utils

import javafx.scene.canvas.Canvas
import javafx.scene.image.Image

fun setImageIntoCanvas(img: Image, canvas: Canvas) {
    val g = canvas.graphicsContext2D
    g.clearRect(0.0, 0.0, canvas.getWidth(), canvas.getHeight());
    var newImageWidth = canvas.getWidth()
    var newImageHeight = canvas.getHeight()
    if (img.width > img.height)
        newImageHeight = img.height * (canvas.getWidth() / img.width)
    else
        newImageWidth = img.width * (canvas.getHeight() / img.height)

    g.drawImage(
        img,
        canvas.width / 2 - newImageWidth / 2,
        canvas.height / 2 - newImageHeight / 2,
        newImageWidth,
        newImageHeight
    )
}