package GUISamples.features.cropper

import GUISamples.features.cropper.utils.openImage
import GUISamples.features.cropper.utils.saveCanvas
import GUISamples.utils.addElementsToMenu
import GUISamples.utils.setImageIntoCanvas
import javafx.event.EventHandler
import javafx.scene.canvas.Canvas
import javafx.scene.control.*
import javafx.scene.paint.Color


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
            val img = openImage()
            if (img != null) setImageIntoCanvas(img, canvas)
        }
        saveImgBtn.onAction = EventHandler {
            saveCanvas(canvas)
        }

    }
}
