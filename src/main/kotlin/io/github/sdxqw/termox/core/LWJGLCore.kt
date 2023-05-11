package io.github.sdxqw.termox.core

import io.github.sdxqw.termox.Termox
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.nanovg.NanoVG.nvgBeginFrame
import org.lwjgl.nanovg.NanoVG.nvgEndFrame
import org.lwjgl.nanovg.NanoVGGL3
import org.lwjgl.nanovg.NanoVGGL3.nvgDelete
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL


class LWJGLCore : LWJGL {
    private val window = Window()

    fun start() {
        initialize()
        while (!glfwWindowShouldClose(window.window)) {
            renderFrame()
            updateGameState()
            glfwSwapBuffers(window.window)
            glfwPollEvents()
        }
        cleanup()
    }

    /**
     * Initializes GLFW, creates the window, creates the OpenGL context and NanoVG context.
     */
    override fun initialize() {
        GLFWErrorCallback.createPrint(System.err).set()
        if (!glfwInit()) {
            throw RuntimeException("Unable to initialize GLFW")
        }
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE)
        window.window = glfwCreateWindow(window.width, window.height, "KK Pong Game", NULL, NULL)
        if (window.window === NULL) {
            glfwTerminate()
            throw IllegalArgumentException("Failed to create the GLFW window")
        }
        val videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor())!!
        glfwSetWindowPos(
            window.window, ((videoMode.width() - window.width) / 2).toInt(),
            ((videoMode.height() - window.height) / 2).toInt()
        )
        glfwMakeContextCurrent(window.window)
        glfwShowWindow(window.window)
        GL.createCapabilities()
        window.nvg = NanoVGGL3.nvgCreate(NanoVGGL3.NVG_ANTIALIAS or NanoVGGL3.NVG_STENCIL_STROKES)
        check(window.nvg !== NULL) { "Failed to create NVG context" }
        glMatrixMode(GL_PROJECTION)
        glLoadIdentity()
        glOrtho(0.0, window.width.toDouble(), 0.0, window.height.toDouble(), 1.0, -1.0)
        glMatrixMode(GL_MODELVIEW)
        Termox.getInstance().initialize()
    }

    /**
     * Clears the screen, begins the NanoVG frame, renders the game frame and ends the NanoVG frame.
     */
    override fun renderFrame() {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)
        glClearColor(0.2f, 0.2f, 0.2f, 0.2f)
        nvgBeginFrame(window.nvg, window.width.toFloat(), window.height.toFloat(), 1f)
        Termox.getInstance().renderFrame()
        nvgEndFrame(window.nvg)
    }

    /**
     * Updates the game state by calling the updateGameState() method from the CmdCore singleton instance.
     * This method is called once per frame in the main game loop.
     */
    override fun updateGameState() {
        Termox.getInstance().updateGameState()
    }

    /**
     * Cleans up resources used by the game, including the GLFW window and NanoVG context, by calling the cleanup()
     * This method is called when the game is exiting.
     */
    override fun cleanup() {
        Termox.getInstance().cleanup()
        if (window.window != NULL) glfwDestroyWindow(window.window)
        if (window.nvg != NULL) nvgDelete(window.nvg)
        glfwTerminate()
    }
}