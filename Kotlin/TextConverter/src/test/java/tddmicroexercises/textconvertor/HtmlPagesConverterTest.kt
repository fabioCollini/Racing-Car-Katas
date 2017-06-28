package tddmicroexercises.textconvertor

import org.junit.Assert.*

import java.io.IOException

import org.junit.Test


class HtmlPagesConverterTest {
    @Test
    @Throws(IOException::class)
    fun foo() {
        val converter = HtmlPagesConverter("foo")
        assertEquals("fixme", converter.filename)
    }
}
