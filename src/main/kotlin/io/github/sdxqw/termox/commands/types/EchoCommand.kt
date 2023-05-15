package io.github.sdxqw.termox.commands.types

import io.github.sdxqw.termox.commands.Command

class EchoCommand : Command("echo", "say shiiii", mutableListOf("e")) {
    override fun execute(args: MutableList<String>) {
        if (args.isNotEmpty()) {
            val command = args[0].split("\\s+".toRegex())
            if (command[0] == name || command[0] in aliases) {
                println(usage)
                if (args.size > 1 && args[1].isNotEmpty()) {
                    println(args[1])
                }
            }
        }
    }

}