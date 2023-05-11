package io.github.sdxqw.termox.core

interface LWJGL {
    /**
     * Initializes the client, setting up any necessary resources.
     */
    fun initialize()

    /**
     * Renders a single frame of the game's user interface.
     */
    fun renderFrame()

    /**
     * Updates the game's state, based on user input or other events.
     */
    fun updateGameState()

    /**
     * Cleans up any resources used by the client.
     */
    fun cleanup()
}