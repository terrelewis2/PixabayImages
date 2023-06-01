package com.terrellewis.pixabay.images.core.util


fun String.getAsList(): List<String> {
    val items = this.split(",").map {
        "#${it.replace(" ", "").trim()}"
    }
    return items
}
