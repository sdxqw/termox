package io.github.sdxqw.termox.ui

import io.github.sdxqw.termox.ui.basic.UIScreen
import io.github.sdxqw.termox.ui.menu.MainMenu

class ManagerUI {
    private var currentScreen: UIScreen? = null

    init {
        setScreen(MainMenu())
    }

    private fun setScreen(screen: UIScreen) {
        currentScreen = screen
        currentScreen?.initialize()
    }

    fun initializeScreen() {
        currentScreen?.initialize()
    }

    fun drawScreen(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        currentScreen?.drawScreen(nvg, window, windowWidth, windowHeight)
    }

    fun updateScreen(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        currentScreen?.updateScreen(nvg, window, windowWidth, windowHeight)
    }

    fun clearScreen(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        currentScreen?.clearScreen(nvg, window, windowWidth, windowHeight)
    }
}
