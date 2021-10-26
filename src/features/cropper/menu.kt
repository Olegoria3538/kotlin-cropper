package GUISamples.features.cropper

import GUISamples.features.cropper.utils.openImage
import GUISamples.features.cropper.utils.saveImage
import GUISamples.utils.addElementToMenu
import GUISamples.utils.addElementsToMenu
import GUISamples.utils.canvasToImage
import GUISamples.utils.setImageIntoCanvas
import javafx.embed.swing.SwingFXUtils
import javafx.event.EventHandler
import javafx.scene.canvas.Canvas
import javafx.scene.control.*
import javafx.scene.paint.Color
import javafx.stage.FileChooser
import javafx.stage.Stage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO


class createMenu(val canvas: Canvas) {
    val menu = Menu("СУПЕР МЕНЮ")
    val slider = Slider(1.0, 100.0, 10.0)
    val openImgBtn = Button("Открыть другое изображение")
    val saveImgBtn = Button("Сохранить изображение")
    val menuBar = MenuBar()
    val colorPicker = ColorPicker()
    val clearCheck = CheckBox("Ластик")

    fun getSizeBrash(): Double {
        return slider.value
    }

    fun getColorBrash(): Color {
        return colorPicker.value
    }

    fun getCheckClear(): Boolean {
        return clearCheck.isSelected
    }


    init {
        menuBar.menus.add(menu)
        addElementsToMenu(menu, listOf(slider, colorPicker, clearCheck, openImgBtn, saveImgBtn))

        openImgBtn.onAction = EventHandler {
            setImageIntoCanvas(openImage(), canvas)
        }
        saveImgBtn.onAction = EventHandler {
            saveImage(canvas)
        }

    }
}
