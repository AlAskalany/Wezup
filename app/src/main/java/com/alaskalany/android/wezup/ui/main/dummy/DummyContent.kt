package com.alaskalany.android.wezup.ui.main.dummy

import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    private val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private const val COUNT = 7

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): DummyItem {
        when (position) {
            1 -> {
                return DummyItem(position.toString(), "Monday", "Cloudy", "", "")
            }
            2 -> {
                return DummyItem(position.toString(), "Tuesday", "Rainy", "", "")
            }
            3 -> {
                return DummyItem(position.toString(), "Wednesday", "Cloudy", "", "")
            }
            4 -> {
                return DummyItem(position.toString(), "Thursday", "Cloudy", "", "")
            }
            5 -> {
                return DummyItem(position.toString(), "Friday", "Sunny", "", "")
            }
            6 -> {
                return DummyItem(position.toString(), "Saturday", "Cloudy", "", "")
            }
            7 -> {
                return DummyItem(position.toString(), "Sunday", "Rainy", "", "")
            }
            else -> {
                return DummyItem(
                    position.toString(),
                    "Item $position",
                    makeDetails(position),
                    "",
                    ""
                )
            }
        }
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(
        val id: String,
        val day: String,
        val weatherSummary: String,
        val temperatureMin: String,
        val temperatureMax: String
    ) {

        override fun toString(): String = day
    }
}
