package GUISamples.features.cropper.utils

import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.WritableImage
import javafx.stage.FileChooser
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

fun openImage(): WritableImage? {
    try {
        val fileChooser = FileChooser()
        val extFilterJPG = FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg")
        val extFilterPNG = FileChooser.ExtensionFilter("PNG files (*.png)", "*.png")
        fileChooser.extensionFilters.addAll(extFilterJPG, extFilterPNG)
        val file = fileChooser.showOpenDialog(null)
        val bufferedImage = ImageIO.read(file)
        return SwingFXUtils.toFXImage(bufferedImage, null)
    } catch (e: IOException) {
        return null
    }
}

fun openImage(path: String): WritableImage? {
    try {
        val file = File(path)
        val bufferedImage = ImageIO.read(file)
        return SwingFXUtils.toFXImage(bufferedImage, null)
    } catch (e: IOException) {
        return null
    }
}