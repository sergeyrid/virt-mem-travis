import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProcessAnyTests {
    @Test
    fun `process FIFO`() {
        Assertions.assertEquals(processAny(
            IntArray(5) {-1}.toList(),
            listOf(1, 2, 3, 4, 5, 1, 5, 2, 6, 7, 8, 2),
            Algorithms.FIFO
        ),
            listOf(
                Operation(true, 1, 1),
                Operation(true, 2, 2),
                Operation(true, 3, 3),
                Operation(true, 4, 4),
                Operation(true, 5, 5),
                Operation(false, 1, 0),
                Operation(false, 5, 0),
                Operation(false, 2, 0),
                Operation(true, 6, 1),
                Operation(true, 7, 2),
                Operation(true, 8, 3),
                Operation(true, 2, 4)
            )
        )
    }

    @Test
    fun `process LRU`() {
        Assertions.assertEquals(processAny(
            IntArray(5) {-1}.toList(),
            listOf(1, 2, 3, 4, 5, 1, 5, 2, 6, 7, 8, 2),
            Algorithms.LRU
        ),
            listOf(
                Operation(true, 1, 1),
                Operation(true, 2, 2),
                Operation(true, 3, 3),
                Operation(true, 4, 4),
                Operation(true, 5, 5),
                Operation(false, 1, 0),
                Operation(false, 5, 0),
                Operation(false, 2, 0),
                Operation(true, 6, 3),
                Operation(true, 7, 4),
                Operation(true, 8, 1),
                Operation(false, 2, 0)
            )
        )
    }

    @Test
    fun `process OPT`() {
        Assertions.assertEquals(processAny(
            IntArray(5) {-1}.toList(),
            listOf(1, 2, 3, 4, 5, 1, 5, 2, 6, 7, 8, 2),
            Algorithms.OPT
        ),
            listOf(
                Operation(true, 1, 1),
                Operation(true, 2, 2),
                Operation(true, 3, 3),
                Operation(true, 4, 4),
                Operation(true, 5, 5),
                Operation(false, 1, 0),
                Operation(false, 5, 0),
                Operation(false, 2, 0),
                Operation(true, 6, 1),
                Operation(true, 7, 3),
                Operation(true, 8, 4),
                Operation(false, 2, 0)
            )
        )
    }
}
