package io.github.sdxqw.termox.ui.basic

abstract class UIComponent(var x: Float, var y: Float, var width: Float, var height: Float) {
    abstract fun draw()

    abstract fun update()
}