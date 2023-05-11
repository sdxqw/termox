package io.github.sdxqw.termox.ui.basic

open class UIScreen(name: String) {
    private val components: List<UIComponent> = ArrayList()
    val name = name

    open fun initialize() {

    }

    open fun drawScreen() {
        components.forEach(UIComponent::draw)
    }

    open fun updateScreen() {
        components.forEach(UIComponent::update)
    }
}