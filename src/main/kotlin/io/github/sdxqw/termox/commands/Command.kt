package io.github.sdxqw.termox.commands

abstract class Command(val name: String, val usage: String, val aliases: MutableList<String>) {
    abstract fun execute(args: MutableList<String>)
}