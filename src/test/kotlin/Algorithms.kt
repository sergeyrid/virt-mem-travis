import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProcessOneFIFOTests {
    @Test
    fun `queue contains page`() {
        Assertions.assertEquals(processOneFIFO(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            3),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6), 3))
    }
}

class ProcessOneLRUTests {
    @Test
    fun `queue contains page`() {
        Assertions.assertEquals(processOneLRU(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            3),
            Pair(mutableListOf(1, 2, 4, 5, 6, 3), 3))
    }
}

class ProcessOneOPTTests {
    @Test
    fun `page is optimal`() {
        Assertions.assertEquals(processOneOPT(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            listOf(5, 2, 1, 6, 4, 2, 5),
            3),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6), 3))
    }
}

class FindOptimalTests {
    @Test
    fun `normal situation`() {
        Assertions.assertEquals(findOptimal(mutableListOf(1, 2, 3, 4, 5, 6), listOf(5, 2, 1, 6, 4, 2, 5)),
            2)
    }
}