package GUISamples.utils

import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.WritableImage
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit

fun getScreenshot(): WritableImage {
    val screenRect = Rectangle(Toolkit.getDefaultToolkit().screenSize)
    val capture = Robot().createScreenCapture(screenRect)
    return SwingFXUtils.toFXImage(capture, null)
}