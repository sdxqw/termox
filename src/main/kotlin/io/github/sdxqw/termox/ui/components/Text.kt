package io.github.sdxqw.termox.ui.components

import io.github.sdxqw.termox.grapichs.font.FontManager
import io.github.sdxqw.termox.ui.basic.UIComponent
import org.lwjgl.nanovg.NVGColor

class Text(
    private val text: String,
    private val positionX: Float,
    private val positionY: Float,
    private val sizeFont: Float,
    private val color: NVGColor
) : UIComponent() {

    override fun render(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        FontManager.drawRobotoText(text, positionX, positionY, sizeFont, color)
    }

    override fun updateState(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
    }

    override fun clearState(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
    }
}