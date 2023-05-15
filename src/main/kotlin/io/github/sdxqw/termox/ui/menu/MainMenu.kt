package io.github.sdxqw.termox.ui.menu

import io.github.sdxqw.termox.grapichs.NanoVGC
import io.github.sdxqw.termox.ui.basic.UIScreen
import io.github.sdxqw.termox.ui.components.Text
import io.github.sdxqw.termox.ui.components.TextBox
import io.github.sdxqw.termox.ui.components.TextInput

class MainMenu : UIScreen() {
    override fun initialize() {
        addComponent(
            Text("Such", 100f, 100f, 21f, NanoVGC.color(1f, 1f, 1f, 1f)),
            TextInput(100f, 100f, 200f, 200f, 21f),
            TextBox("Text", 190f, 100f, 21f)
        )
    }
}