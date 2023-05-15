package io.github.sdxqw.termox.grapichs.font

import org.lwjgl.nanovg.NVGColor

/**
 * The FontManager class is responsible for managing fonts used in the application.
 * It provides methods to load fonts, draw text using the loaded fonts, and measure the width of text.
 */
object FontManager {
    private val font: Font = Font()
    private var ROBOTO = "roboto"

    /**
     * Initializes the Roboto font by loading it from a file.
     * This method should be called once at the start of the application.
     */
    fun loadFonts(nvg: Long) {
        font.init(nvg, ROBOTO, "Roboto-Regular")
    }

    /**
     * Draws text using the Roboto font.
     * @param text the text to draw
     * @param x the x-coordinate of the text position
     * @param y the y-coordinate of the text position
     * @param size the size of the text
     * @param color the color of the text
     */
    fun drawRobotoText(text: String, x: Float, y: Float, size: Float, color: NVGColor) {
        font.drawText(text, x, y, ROBOTO, size, color)
    }

    /**
     * Measures the width of text using a specified font and font size.
     * @param text the text to measure
     * @param name the name of the font to use
     * @param fontSize the size of the font to use
     * @return the width of the text
     */
    fun measureTextWidth(text: String, name: String, fontSize: Float): Float {
        return font.measureTextWidth(text, name, fontSize)
    }

    /**
     * Returns the height of the specified text when drawn with the given font and size.
     *
     * @param name     the name of the font to use
     * @return the height of the font in pixels
     */
    fun getTextHeight(name: String): Float {
        return font.getTextHeight(name)
    }
}