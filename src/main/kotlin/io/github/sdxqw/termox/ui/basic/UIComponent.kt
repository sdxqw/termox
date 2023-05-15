package io.github.sdxqw.termox.ui.basic

open class UIComponent {
    open fun render(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {}

    open fun updateState(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {}

    open fun clearState(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {}
}