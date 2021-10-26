package GUISamples.features.cropper.utils

import GUISamples.utils.canvasToImage
import javafx.embed.swing.SwingFXUtils
import javafx.scene.canvas.Canvas
import javafx.stage.FileChooser
import javafx.stage.Stage
import java.io.File
import javax.imageio.ImageIO

fun saveImage(canvas: Canvas) {
    val window = Stage()
    val fileChooser = FileChooser()
    val extFilter = FileChooser.ExtensionFilter(
        "image files (*.png)", "*.png"
    )
    fileChooser.extensionFilters.add(extFilter)
    var file = fileChooser.showSaveDialog(window)
    if (file != null) {
        val fileName = file.name
        if (!fileName.toUpperCase().endsWith(".PNG")) {
            file = File(file.absolutePath + ".png")
        }
        val img = canvasToImage(canvas, null)
        ImageIO.write(
            SwingFXUtils.fromFXImage(img, null),
            "png", file
        )
    }
}