package io.github.sdxqw.termox

import io.github.sdxqw.termox.commands.CommandManager
import io.github.sdxqw.termox.core.LWJGL
import io.github.sdxqw.termox.grapichs.font.FontManager
import io.github.sdxqw.termox.ui.ManagerUI
import io.github.sdxqw.termox.utils.Utils

class Termox : LWJGL() {
    companion object {
        private val instance = Termox()

        fun getInstance(): Termox {
            return instance
        }
    }

    private val managerUI = ManagerUI()
    val commandManager = CommandManager()

    override fun initialize(nvg: Long, window: Long) {
        FontManager.loadFonts(nvg)
        managerUI.initializeScreen()

    }

    override fun renderFrame(nvg: Long, window: Long) {
        managerUI.drawScreen(nvg, window, Utils.width, Utils.height)
    }

    override fun updateGameState(nvg: Long, window: Long) {
        managerUI.updateScreen(nvg, window, Utils.width, Utils.height)
    }

    override fun cleanup(nvg: Long, window: Long) {
        managerUI.clearScreen(nvg, window, Utils.width, Utils.height)
    }
}