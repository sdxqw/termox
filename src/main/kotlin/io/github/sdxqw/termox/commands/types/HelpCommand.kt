package io.github.sdxqw.termox.commands.types

import io.github.sdxqw.termox.commands.Command

class HelpCommand : Command("help", "Goofy ahh termox.", mutableListOf("h")) {
    override fun execute(args: MutableList<String>) {
        if (args.contains(name) || args == aliases) {
            println(usage)
        }
    }
}