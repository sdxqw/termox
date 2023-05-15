package io.github.sdxqw.termox.utils

import java.io.IOException
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Path
import java.nio.file.StandardOpenOption

object Utils {

    /**
     * The width of the game window.
     */
    const val width = 820

    /**
     * The height of the game window.
     */
    const val height = 420

    /**
     * Reads the contents of a file at the specified path into a direct ByteBuffer.
     *
     * @param path the path of the file to read
     * @return a direct ByteBuffer containing the contents of the file, or null if an error occurred
     */
    fun readFile(path: Path): ByteBuffer {
        try {
            FileChannel.open(path, StandardOpenOption.READ).use { fc ->
                if (fc.size() == 0L) throw RuntimeException("File is empty: $path")
                val buffer =
                    ByteBuffer.allocateDirect(Math.toIntExact(fc.size()))
                if (fc.read(buffer) == -1) throw IOException("Failed to read from file: $path")
                buffer.flip()
                return buffer
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}