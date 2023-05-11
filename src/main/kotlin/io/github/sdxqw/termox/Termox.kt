package io.github.sdxqw.termox

import io.github.sdxqw.termox.core.LWJGL
import io.github.sdxqw.termox.ui.ManagerUI

class Termox : LWJGL {
    companion object {
        private val instance = Termox()

        fun getInstance(): Termox {
            return instance
        }
    }

    private val managerUI = ManagerUI()

    override fun initialize() {
    }

    override fun renderFrame() {
        managerUI.setScreen("MainMenu")
    }

    override fun updateGameState() {

    }

    override fun cleanup() {

    }
}