package io.github.sds100.keymapper.sorting.comparators

import io.github.sds100.keymapper.mappings.keymaps.KeyMap

// Comparator.reversed() requires API level 24
class KeyMapOptionsComparator(
    private val reverse: Boolean = false,
) : Comparator<KeyMap> {
    override fun compare(
        keyMap: KeyMap?,
        otherKeyMap: KeyMap?,
    ): Int {
        if (keyMap == null || otherKeyMap == null) {
            return 0
        }

        val result = compareValuesBy(
            keyMap,
            otherKeyMap,
            { it.vibrate },
            { it.trigger.screenOffTrigger },
            { it.trigger.triggerFromOtherApps },
            { it.showToast },
        )

        return doFinal(result)
    }

    fun doFinal(result: Int) = if (reverse) {
        result * -1
    } else {
        result
    }
}
