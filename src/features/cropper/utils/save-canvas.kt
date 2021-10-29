package GUISamples.features.cropper.utils

import GUISamples.utils.canvasToImage
import javafx.embed.swing.SwingFXUtils
import javafx.scene.canvas.Canvas
import javafx.scene.image.WritableImage
import javafx.stage.FileChooser
import javafx.stage.Stage
import java.io.DataOutputStream
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.imageio.ImageIO


private fun writableImageSave(img: WritableImage, file: File) {
    DataOutputStream(FileOutputStream("kek.lol")).use { dos -> dos.writeUTF(file.path) }
    ImageIO.write(
        SwingFXUtils.fromFXImage(img, null),
        "png", file
    )
}

fun saveCanvas(canvas: Canvas) {
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
        writableImageSave(img, file)
    }
}

fun quicksaveCanvas(canvas: Canvas) {
    val dtf = DateTimeFormatter.ofPattern("yyyy:MM:dd-HH:mm:ss")
    val time = dtf.format(LocalDateTime.now())
    val fileName = "super-image-$time"
    val file = File("$fileName.png")
    val img = canvasToImage(canvas, null)
    writableImageSave(img, file)
}