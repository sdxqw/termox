package io.github.sdxqw.termox.core

open class LWJGL {

    /**
     * Initializes the client, setting up any necessary resources.
     */
    open fun initialize(nvg: Long, window: Long) {}

    /**
     * Renders a single frame of the game's user interface.
     */
    open fun renderFrame(nvg: Long, window: Long) {}

    /**
     * Updates the game's state, based on user input or other events.
     */
    open fun updateGameState(nvg: Long, window: Long) {}

    /**
     * Cleans up any resources used by the client.
     */
    open fun cleanup(nvg: Long, window: Long) {}

    /**
     * Initializes the client, setting up any necessary resources.
     */
    open fun initialize() {}

    /**
     * Renders a single frame of the game's user interface.
     */
    open fun renderFrame() {}

    /**
     * Updates the game's state, based on user input or other events.
     */
    open fun updateGameState() {}

    /**
     * Cleans up any resources used by the client.
     */
    open fun cleanup() {}
}