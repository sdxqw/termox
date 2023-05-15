package io.github.sdxqw.termox.ui.menu

import io.github.sdxqw.termox.grapichs.NanoVGC
import io.github.sdxqw.termox.ui.basic.UIScreen
import io.github.sdxqw.termox.ui.components.Text

class MainMenu : UIScreen() {
    override fun initialize() {
        addComponent(Text("Such", 100f, 100f, 21f, NanoVGC.color(1f, 1f, 1f, 1f)))
    }
}