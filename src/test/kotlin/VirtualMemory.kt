import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProcessAllTests {

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
