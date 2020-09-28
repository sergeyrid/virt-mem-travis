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
            Pair(
                listOf(
                    "Frame 1 should be substituted with page 1",
                    "Frame 2 should be substituted with page 2",
                    "Frame 3 should be substituted with page 3",
                    "Frame 4 should be substituted with page 4",
                    "Frame 5 should be substituted with page 5",
                    "Page 1 has already been loaded into memory",
                    "Page 5 has already been loaded into memory",
                    "Page 2 has already been loaded into memory",
                    "Frame 1 should be substituted with page 6",
                    "Frame 2 should be substituted with page 7",
                    "Frame 3 should be substituted with page 8",
                    "Frame 4 should be substituted with page 2"
                ),
                9
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
            Pair(
                listOf(
                    "Frame 1 should be substituted with page 1",
                    "Frame 2 should be substituted with page 2",
                    "Frame 3 should be substituted with page 3",
                    "Frame 4 should be substituted with page 4",
                    "Frame 5 should be substituted with page 5",
                    "Page 1 has already been loaded into memory",
                    "Page 5 has already been loaded into memory",
                    "Page 2 has already been loaded into memory",
                    "Frame 3 should be substituted with page 6",
                    "Frame 4 should be substituted with page 7",
                    "Frame 1 should be substituted with page 8",
                    "Page 2 has already been loaded into memory"
                ),
                8
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
            Pair(
                listOf(
                    "Frame 1 should be substituted with page 1",
                    "Frame 2 should be substituted with page 2",
                    "Frame 3 should be substituted with page 3",
                    "Frame 4 should be substituted with page 4",
                    "Frame 5 should be substituted with page 5",
                    "Page 1 has already been loaded into memory",
                    "Page 5 has already been loaded into memory",
                    "Page 2 has already been loaded into memory",
                    "Frame 1 should be substituted with page 6",
                    "Frame 3 should be substituted with page 7",
                    "Frame 4 should be substituted with page 8",
                    "Page 2 has already been loaded into memory"
                ),
                8
            )
        )
    }
}

class CallAlgorithmTests {
    @Test
    fun `call FIFO (result is similar with OPT)`() {
        Assertions.assertEquals(callAlgorithm(
            mutableListOf(3, 1, 5, 4, 2),
            5,
            8,
            mutableListOf(3, 1, 5, 3, 4, 2, 2, 1, 3, 4, 3),
            Algorithms.FIFO
        ),
            processOneFIFO(
                mutableListOf(3, 1, 5, 4, 2),
                5,
                3
            )
        )
    }

    @Test
    fun `call FIFO (result is similar with LRU)`() {
        Assertions.assertEquals(callAlgorithm(
            mutableListOf(3, 1, 5, 4, 2),
            5,
            8,
            mutableListOf(3, 1, 5, 3, 4, 2, 2, 1, 6, 4, 3),
            Algorithms.FIFO
        ),
            processOneFIFO(
                mutableListOf(3, 1, 5, 4, 2),
                5,
                6
            )
        )
    }

    @Test
    fun `call LRU`() {
        Assertions.assertEquals(callAlgorithm(
            mutableListOf(5, 3, 4, 2, 1),
            5,
            8,
            mutableListOf(3, 1, 5, 3, 4, 2, 2, 1, 3, 4, 3),
            Algorithms.LRU
        ),
            processOneLRU(
                mutableListOf(5, 4, 2, 1, 3),
                5,
                3
            )
        )
    }

    @Test
    fun `call OPT`() {
        Assertions.assertEquals(callAlgorithm(
            mutableListOf(3, 1, 5, 4, 2),
            5,
            8,
            mutableListOf(3, 1, 5, 3, 4, 2, 2, 1, 6, 4, 3),
            Algorithms.OPT
        ),
            processOneOPT(
                mutableListOf(3, 1, 5, 4, 2),
                5,
                mutableListOf(6, 4, 3),
                6
            )
        )
    }
}
