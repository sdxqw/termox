package io.github.sdxqw.termox.ui.basic

abstract class UIComponent {
    abstract fun render(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int)

    abstract fun updateState(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int)

    abstract fun clearState(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int)
}