package goncalo.designpatterns.flyweight

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals


/*
 * Created by: @author Gonçalo Silva
 * 15/05/2020
 */

class PaintStoreTest {

    /**
     * Test asserts that all we will only have the expected number of colors created in cache
     */
    @ParameterizedTest
    @MethodSource
    fun testSell(wantedColors: Stream<String>, expectedNumberValuesInCache: Int) {
        val p = PaintStore()
        p.sell(wantedColors)
        val colorInCache = Color.colorsInCache()
        assertEquals(expectedNumberValuesInCache, colorInCache)
    }


    companion object {
        /**
         * @JvmStatic exposes this method as static to jvm, which is needed for the ParameterizedTest annotation to work
         */
        @JvmStatic
        fun testSell(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of(
                            Stream.of("blue", "red", "blue", "green", "blue"),
                            3
                    )
            )
        }
    }
}