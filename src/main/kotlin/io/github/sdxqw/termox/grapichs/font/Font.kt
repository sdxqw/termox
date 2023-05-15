package io.github.sdxqw.termox.grapichs.font

import io.github.sdxqw.termox.utils.Utils
import org.lwjgl.BufferUtils
import org.lwjgl.nanovg.NVGColor
import org.lwjgl.nanovg.NanoVG.*
import java.nio.FloatBuffer
import java.nio.file.Paths


/**
 * The Font class provides functionality for loading and drawing fonts using NanoVG.
 */
class Font {

    private var nvg = 0L

    /**
     * Initializes a font with the given name and font file.
     *
     * @param name     the name of the font
     * @param fontName the name of the font file
     */
    fun init(nvg: Long, name: String, fontName: String) {
        this.nvg = nvg
        val fontBuffer = Utils.readFile(Paths.get(Utils::class.java.getResource("/fonts/$fontName.ttf")?.toURI() ?: throw Exception("Font not found")))
        nvgCreateFontMem(nvg, name, fontBuffer, true)
    }

    /**
     * Draws the specified text with the given font, size, and color at the specified position.
     *
     * @param text     the text to draw
     * @param x        the x-coordinate of the starting position
     * @param y        the y-coordinate of the starting position
     * @param font     the name of the font to use
     * @param fontSize the size of the font to use
     * @param color    the color of the text to draw
     */
    fun drawText(text: String, x: Float, y: Float, font: String, fontSize: Float, color: NVGColor) {
        nvgFontFace(nvg, font)
        nvgFontSize(nvg, fontSize)
        nvgFillColor(nvg, color)
        nvgText(nvg, x, y, text)
    }

    /**
     * Returns the width of the specified text when drawn with the given font and size.
     *
     * @param text     the text to measure
     * @param font     the name of the font to use
     * @param fontSize the size of the font to use
     * @return the width of the text in pixels
     */
    fun measureTextWidth(text: String, font: String, fontSize: Float): Float {
        nvgFontFace(nvg, font)
        nvgFontSize(nvg, fontSize)
        return nvgTextBounds(nvg, 0f, 0f, text, null as FloatBuffer?)
    }

    /**
     * Returns the height of the specified text when drawn with the given font and size.
     *
     * @param font the name of the font to use
     * @return the height of the font in pixels
     */
    fun getTextHeight(font: String): Float {
        nvgFontFace(nvg, font)
        val lineh = BufferUtils.createFloatBuffer(1)
        nvgTextMetrics(nvg, null, null, lineh)
        return lineh[0]
    }
}