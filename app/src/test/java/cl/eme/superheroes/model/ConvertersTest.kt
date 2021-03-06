package cl.eme.superheroes.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.Before

class ConvertersTest {
    lateinit var converter: Converters

    @Before
    fun setup(){
        converter= Converters()
    }

    @Test
    fun list2String() {
        // Given
        val inputList= listOf("value1", "value2", "value3")
        val expected= "value1, value2, value3"

        //When
        val result = converter.list2String(inputList)

        // Then
        assertThat(result).isNotNull()
        assertThat(result).isNotEmpty()
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun string2List() {
        // Given
        val inputString = "value1, value2, value 3"

        // When
        val result = converter.string2List(inputString)

        // Then
        assertThat(result).isNotNull()
        assertThat(result).hasSize(3)
        assertThat(result[0]).isEqualTo("value1")
        assertThat(result[2]).isEqualTo("value 3")
    }
}