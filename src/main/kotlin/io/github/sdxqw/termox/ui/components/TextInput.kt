package io.github.sdxqw.termox.ui.components

import io.github.sdxqw.termox.Termox
import io.github.sdxqw.termox.grapichs.NanoVGC
import io.github.sdxqw.termox.grapichs.font.FontManager
import io.github.sdxqw.termox.ui.basic.UIComponent
import io.github.sdxqw.termox.utils.Keyboard
import org.lwjgl.glfw.GLFW


class TextInput(
    private val positionX: Float,
    private val positionY: Float,
    private val width: Float,
    private val height: Float,
    private val sizeFont: Float,
) : UIComponent() {

    private var textInput: StringBuilder = StringBuilder()

    private val getTextInput: String
        get() = textInput.toString()

    private var cursorPosition = 0

    override fun render(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        val rectCenterX = positionX + width / 2f
        val rectCenterY = positionY + height / 2f

        NanoVGC.drawRoundedRect(nvg, positionX, positionY, width, height, 12f, NanoVGC.color(0.5f, 0.5f, 0.5f, 1f))

        val textX = rectCenterX - FontManager.getTextWidth(getTextInput, "roboto", sizeFont) / 2f
        val textY = rectCenterY + FontManager.getTextHeight("roboto") / 2f

        if (cursorPosition < 0) cursorPosition = 0

        val cursorBottomY: Float = textY - FontManager.getTextHeight("roboto") / 2 - 6
        val cursorTopY: Float = textY + FontManager.getTextHeight("roboto") / 2 - 6

        val cursorX: Float =
            textX + FontManager.getTextWidth(getTextInput.substring(0, cursorPosition), "roboto", sizeFont)

        FontManager.drawRobotoText(getTextInput, textX - 55, textY, sizeFont, NanoVGC.color(1f, 1f, 1f, 1f))
        NanoVGC.drawLine(
            nvg,
            cursorX,
            cursorTopY,
            cursorX,
            cursorBottomY,
            sizeFont / 10f,
            NanoVGC.color(1f, 1f, 1f, 1f)
        )
    }

    override fun updateState(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        GLFW.glfwSetKeyCallback(window) { _, key, _, action, _ ->
            Keyboard.onKey(window, textInput, key, action)
            Keyboard.onEnter(window, action, ({
                Termox.getInstance().commandManager.commands.forEach {
                    it.execute(
                        mutableListOf(getTextInput)
                    )
                }
            }))
        }
    }

}