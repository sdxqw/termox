package io.github.sdxqw.termox.commands

import io.github.sdxqw.termox.commands.types.EchoCommand
import io.github.sdxqw.termox.commands.types.HelpCommand

class CommandManager {
    val commands: MutableList<Command> = mutableListOf()

    init {
        commands.addAll(mutableListOf(HelpCommand(), EchoCommand()))
    }
}