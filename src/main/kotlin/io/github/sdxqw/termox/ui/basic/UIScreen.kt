package io.github.sdxqw.termox.ui.basic

open class UIScreen {
    open val components: MutableList<UIComponent> = mutableListOf()

    fun addComponent(component: UIComponent) {
        components.add(component)
    }

    open fun initialize() {}

    open fun drawScreen(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        components.forEach { e -> e.render(nvg, window, windowWidth, windowHeight) }
    }

    open fun updateScreen(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        components.forEach { e -> e.updateState(nvg, window, windowWidth, windowHeight) }
    }

    open fun clearScreen(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        components.forEach { e -> e.clearState(nvg, window, windowWidth, windowHeight) }
    }
}