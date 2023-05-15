package io.github.sdxqw.termox.core

import io.github.sdxqw.termox.Termox
import io.github.sdxqw.termox.utils.Utils
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.nanovg.NanoVG.nvgBeginFrame
import org.lwjgl.nanovg.NanoVG.nvgEndFrame
import org.lwjgl.nanovg.NanoVGGL3
import org.lwjgl.nanovg.NanoVGGL3.nvgDelete
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL


class LWJGLCore : LWJGL() {

    /**
     * The handle of the game window, represented as a long value.
     */
    private var window = 0L

    /**
     * The handle of the NanoVG graphics context, represented as a long value.
     */
    var nvg = 0L

    fun start() {
        initialize()
        while (!glfwWindowShouldClose(window)) {
            renderFrame()
            updateGameState()
            glfwSwapBuffers(window)
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

        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE)
        window = glfwCreateWindow(Utils.width, Utils.height, "Termox", NULL, NULL)
        if (window == NULL) {
            glfwTerminate()
            throw IllegalArgumentException("Failed to create the GLFW window")
        }

        val videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor()) ?: run {
            glfwTerminate()
            throw RuntimeException("Failed to retrieve video mode")
        }

        glfwSetWindowPos(
            window, (videoMode.width() - Utils.width) / 2, (videoMode.height() - Utils.height) / 2
        )

        glfwMakeContextCurrent(window)
        glfwSwapInterval(1)

        GL.createCapabilities()

        nvg = NanoVGGL3.nvgCreate(NanoVGGL3.NVG_ANTIALIAS or NanoVGGL3.NVG_STENCIL_STROKES)
        if (nvg == NULL) {
            glfwTerminate()
            throw RuntimeException("Failed to create NVG context")
        }

        glMatrixMode(GL_PROJECTION)
        glLoadIdentity()
        glOrtho(0.0, Utils.width.toDouble(), 0.0, Utils.height.toDouble(), 1.0, -1.0)
        glMatrixMode(GL_MODELVIEW)

        Termox.getInstance().initialize(nvg, window)
    }


    /**
     * Clears the screen, begins the NanoVG frame, renders the game frame and ends the NanoVG frame.
     */
    override fun renderFrame() {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)
        glClearColor(0.2f, 0.2f, 0.2f, 0.2f)
        nvgBeginFrame(nvg, Utils.width.toFloat(), Utils.height.toFloat(), 1f)
        Termox.getInstance().renderFrame(nvg, window)
        nvgEndFrame(nvg)
    }

    /**
     * Updates the game state by calling the updateGameState() method from the CmdCore singleton instance.
     * This method is called once per frame in the main game loop.
     */
    override fun updateGameState() {
        Termox.getInstance().updateGameState(nvg, window)
    }

    /**
     * Cleans up resources used by the game, including the GLFW window and NanoVG context, by calling the cleanup()
     * This method is called when the game is exiting.
     */
    override fun cleanup() {
        Termox.getInstance().cleanup(nvg, window)
        if (window != NULL) glfwDestroyWindow(window)
        if (nvg != NULL) nvgDelete(nvg)
        glfwTerminate()
    }
}