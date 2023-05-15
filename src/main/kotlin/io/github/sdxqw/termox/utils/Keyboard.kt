package io.github.sdxqw.termox.utils

import org.lwjgl.glfw.GLFW
import java.lang.StringBuilder

object Keyboard {
    fun onKey(window: Long, textInput: StringBuilder, key: Int, action: Int) {
        if (action == GLFW.GLFW_PRESS || action == GLFW.GLFW_REPEAT) {

            val shiftModifier = isShiftKeyPressed(window)
            val char = when (key) {
                in GLFW.GLFW_KEY_0..GLFW.GLFW_KEY_9 -> {
                    if (shiftModifier) {
                        when (key) {
                            GLFW.GLFW_KEY_1 -> '!'
                            GLFW.GLFW_KEY_2 -> '@'
                            GLFW.GLFW_KEY_3 -> '#'
                            GLFW.GLFW_KEY_4 -> '$'
                            GLFW.GLFW_KEY_5 -> '%'
                            GLFW.GLFW_KEY_6 -> '^'
                            GLFW.GLFW_KEY_7 -> '&'
                            GLFW.GLFW_KEY_8 -> '*'
                            GLFW.GLFW_KEY_9 -> '('
                            else -> key.toChar()
                        }
                    } else {
                        (key - GLFW.GLFW_KEY_0 + '0'.code).toChar()
                    }
                }

                in GLFW.GLFW_KEY_A..GLFW.GLFW_KEY_Z -> {
                    val charCode = key - GLFW.GLFW_KEY_A + 'a'.code
                    if (shiftModifier) charCode.toChar().uppercaseChar() else charCode.toChar()
                }

                GLFW.GLFW_KEY_SPACE -> ' '
                GLFW.GLFW_KEY_BACKSPACE -> {
                    if (textInput.isNotEmpty()) {
                        textInput.setLength(textInput.length - 1)
                    }
                    return
                }

                else -> {
                    when (key) {
                        GLFW.GLFW_KEY_GRAVE_ACCENT -> if (shiftModifier) '~' else '`'
                        GLFW.GLFW_KEY_MINUS -> if (shiftModifier) '_' else '-'
                        GLFW.GLFW_KEY_EQUAL -> if (shiftModifier) '+' else '='
                        GLFW.GLFW_KEY_LEFT_BRACKET -> if (shiftModifier) '{' else '['
                        GLFW.GLFW_KEY_RIGHT_BRACKET -> if (shiftModifier) '}' else ']'
                        GLFW.GLFW_KEY_BACKSLASH -> if (shiftModifier) '|' else '\\'
                        GLFW.GLFW_KEY_SEMICOLON -> if (shiftModifier) ':' else ';'
                        GLFW.GLFW_KEY_APOSTROPHE -> if (shiftModifier) '"' else '\''
                        GLFW.GLFW_KEY_COMMA -> if (shiftModifier) '<' else ','
                        GLFW.GLFW_KEY_PERIOD -> if (shiftModifier) '>' else '.'
                        GLFW.GLFW_KEY_SLASH -> if (shiftModifier) '?' else '/'
                        else -> return
                    }
                }
            }

            textInput.append(char)

            Thread.sleep(20)
        }
    }


    private fun isShiftKeyPressed(window: Long): Boolean {
        val shiftState = GLFW.glfwGetKey(window, GLFW.GLFW_KEY_LEFT_SHIFT) == GLFW.GLFW_PRESS || GLFW.glfwGetKey(
            window, GLFW.GLFW_KEY_RIGHT_SHIFT
        ) == GLFW.GLFW_PRESS
        return shiftState || isCapsLockEnabled(window)
    }

    private fun isCapsLockEnabled(window: Long): Boolean {
        return GLFW.glfwGetKey(window, GLFW.GLFW_KEY_CAPS_LOCK) == GLFW.GLFW_PRESS
    }
}