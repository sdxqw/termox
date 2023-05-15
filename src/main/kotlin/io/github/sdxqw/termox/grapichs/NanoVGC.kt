package io.github.sdxqw.termox.grapichs

import org.lwjgl.nanovg.NVGColor
import org.lwjgl.nanovg.NanoVG


/**
 * The NanoVG class provides static utility methods for rendering graphics using the NanoVG library.
 */
object NanoVGC {

    /**
     * Returns an NVGColor object with the specified RGBA values.
     *
     * @param r The red value, ranging from 0.0 to 1.0.
     * @param g The green value, ranging from 0.0 to 1.0.
     * @param b The blue value, ranging from 0.0 to 1.0.
     * @param a The alpha value, ranging from 0.0 to 1.0.
     * @return The NVGColor object with the specified RGBA values.
     */
    fun color(r: Float, g: Float, b: Float, a: Float): NVGColor {
        return NVGColor.calloc().a(a).r(r).g(g).b(b)
    }

    /**
     * Draws a rectangle with the specified position, size, and color.
     *
     * @param x      The x-coordinate of the rectangle's top-left corner.
     * @param y      The y-coordinate of the rectangle's top-left corner.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     * @param color  The color to fill the rectangle width.
     */
    fun drawRect(nvg: Long, x: Float, y: Float, width: Float, height: Float, color: NVGColor) {
        NanoVG.nvgBeginPath(nvg)
        NanoVG.nvgRect(nvg, x, y, width, height)
        NanoVG.nvgFillColor(nvg, color)
        NanoVG.nvgFill(nvg)
    }

    /**
     * Draws a rounded rectangle with the specified position, size, and color.
     *
     * @param x          The x-coordinate of the rectangle's top-left corner.
     * @param y          The y-coordinate of the rectangle's top-left corner.
     * @param width      The width of the rectangle.
     * @param height     The height of the rectangle.
     * @param radius     The radius of the rectangle's corners.
     * @param color      The color to fill the rectangle width.
     */
    fun drawRoundedRect(nvg: Long, x: Float, y: Float, width: Float, height: Float, radius: Float, color: NVGColor) {
        NanoVG.nvgBeginPath(nvg)
        NanoVG.nvgRoundedRect(nvg, x, y, width, height, radius)
        NanoVG.nvgFillColor(nvg, color)
        NanoVG.nvgFill(nvg)
    }

    /**
     * Draws a line between the points (x1, y1) and (x2, y2) with the given color and thickness.
     *
     * @param x1        the x-coordinate of the starting point of the line
     * @param y1        the y-coordinate of the starting point of the line
     * @param x2        the x-coordinate of the ending point of the line
     * @param y2        the y-coordinate of the ending point of the line
     * @param thickness the thickness of the line
     * @param color     the color of the line
     */
    fun drawLine(nvg: Long, x1: Float, y1: Float, x2: Float, y2: Float, thickness: Float, color: NVGColor) {
        NanoVG.nvgBeginPath(nvg)
        NanoVG.nvgMoveTo(nvg, x1, y1)
        NanoVG.nvgLineTo(nvg, x2, y2)
        NanoVG.nvgStrokeColor(nvg, color)
        NanoVG.nvgStrokeWidth(nvg, thickness)
        NanoVG.nvgStroke(nvg)
    }

    /**
     * Draws the border of a rounded rectangle with the specified position, size, color, radius, and thickness.
     *
     * @param x        The x-coordinate of the rectangle's top-left corner.
     * @param y        The y-coordinate of the rectangle's top-left corner.
     * @param width    The width of the rectangle.
     * @param height   The height of the rectangle.
     * @param radius   The radius of the rounded corners.
     * @param thickness The thickness of the border.
     * @param color    The color to fill the border with.
     */
    fun drawRoundedRectBorder(
        nvg: Long,
        x: Float,
        y: Float,
        width: Float,
        height: Float,
        radius: Float,
        thickness: Float,
        color: NVGColor
    ) {
        NanoVG.nvgBeginPath(nvg)
        NanoVG.nvgRoundedRect(nvg, x, y, width, height, radius)
        NanoVG.nvgStrokeWidth(nvg, thickness)
        NanoVG.nvgStrokeColor(nvg, color)
        NanoVG.nvgStroke(nvg)
    }

}