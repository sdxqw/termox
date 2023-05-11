package io.github.sdxqw.termox.ui

import io.github.sdxqw.termox.ui.basic.UIScreen
import io.github.sdxqw.termox.ui.menu.MainMenu

class ManagerUI {
    private val screens: MutableMap<String, UIScreen> = mutableMapOf()

    init {
        addScreen(MainMenu())
    }

    private fun addScreen(screen: UIScreen) {
        screens[screen.name] = screen
        screen.initialize()
    }

    fun setScreen(name: String) {
        val screen = screens[name]
        screen?.let {
            it.drawScreen()
            it.updateScreen()
        }
    }
}