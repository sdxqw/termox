package io.github.sdxqw.termox.ui.components

import io.github.sdxqw.termox.grapichs.NanoVGC
import io.github.sdxqw.termox.grapichs.font.FontManager
import io.github.sdxqw.termox.ui.basic.UIComponent

class TextBox(
    private val text: String,
    private val positionX: Float,
    private val positionY: Float,
    private val sizeFont: Float,
) : UIComponent() {

    override fun render(nvg: Long, window: Long, windowWidth: Int, windowHeight: Int) {
        FontManager.drawRobotoText(text, positionX, positionY, sizeFont, NanoVGC.color(1f, 1f, 1f, 1f))
    }
}