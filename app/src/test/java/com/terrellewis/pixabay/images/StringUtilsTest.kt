package com.terrellewis.pixabay.images

import com.terrellewis.pixabay.images.core.util.getAsList
import org.junit.Test

class StringUtilsTest {

    @Test
    fun `test getAsList`() {
        val string = "one, two, three"
        val list = string.getAsList()
        assert(list.size == 3)
        assert(list[0] == "one")
        assert(list[1] == "two")
        assert(list[2] == "three")
    }
}