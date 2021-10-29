package GUISamples.utils

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import javafx.scene.control.Menu

fun addElementToMenu(menu: Menu, el: Node) {
    val customMenuItem = CustomMenuItem()
    customMenuItem.content = el
    customMenuItem.isHideOnClick = false
    menu.getItems().add(customMenuItem)
}

fun addElementsToMenu(menu: Menu, els: List<Node>) {
    els.forEach { x -> addElementToMenu(menu, x) }
}