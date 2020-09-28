import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProcessOneFIFOTests {
    @Test
    fun `queue contains page and memory isn't full`() {
        Assertions.assertEquals(processOneFIFO(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            3),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6), 3))
    }

    @Test
    fun `queue contains page and memory is full`() {
        Assertions.assertEquals(processOneFIFO(
            mutableListOf(1, 2, 3, 4, 5, 6),
            6,
            3),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6), 3))
    }

    @Test
    fun `queue doesn't contain page and memory isn't full`() {
        Assertions.assertEquals(processOneFIFO(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            10),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6, 10), -1))
    }

    @Test
    fun `queue doesn't contain page and memory is full`() {
        Assertions.assertEquals(processOneFIFO(
            mutableListOf(1, 2, 3, 4, 5, 6),
            6,
            10),
            Pair(mutableListOf(2, 3, 4, 5, 6, 10), 1))
    }
}

class ProcessOneLRUTests {
    @Test
    fun `queue contains page and memory isn't full`() {
        Assertions.assertEquals(processOneLRU(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            3),
            Pair(mutableListOf(1, 2, 4, 5, 6, 3), 3))
    }

    @Test
    fun `queue contains page and memory is full`() {
        Assertions.assertEquals(processOneLRU(
            mutableListOf(1, 2, 3, 4, 5, 6),
            6,
            3),
            Pair(mutableListOf(1, 2, 4, 5, 6, 3), 3))
    }

    @Test
    fun `queue doesn't contain page and memory isn't full`() {
        Assertions.assertEquals(processOneLRU(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            10),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6, 10), -1))
    }

    @Test
    fun `queue doesn't contain page and memory is full`() {
        Assertions.assertEquals(processOneLRU(
            mutableListOf(1, 2, 3, 4, 5, 6),
            6,
            10),
            Pair(mutableListOf(2, 3, 4, 5, 6, 10), 1))
    }
}

class ProcessOneOPTTests {
    @Test
    fun `queue contains page and memory isn't full`() {
        Assertions.assertEquals(processOneOPT(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            listOf(3, 5, 2, 1, 6, 4, 2, 5),
            3),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6), 3))
    }

    @Test
    fun `queue contains page and memory is full`() {
        Assertions.assertEquals(processOneOPT(
            mutableListOf(1, 2, 3, 4, 5, 6),
            6,
            listOf(3, 5, 2, 1, 6, 4, 2, 5),
            3),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6), 3))
    }

    @Test
    fun `queue doesn't contain page and memory isn't full`() {
        Assertions.assertEquals(processOneOPT(
            mutableListOf(1, 2, 3, 4, 5, 6),
            7,
            listOf(10, 5, 2, 1, 6, 4, 2, 5),
            10),
            Pair(mutableListOf(1, 2, 3, 4, 5, 6, 10), -1))
    }

    @Test
    fun `one page in memory is useless`() {
        Assertions.assertEquals(processOneOPT(
            mutableListOf(1, 2, 3, 4, 5, 6),
            6,
            listOf(5, 2, 1, 6, 4, 2, 5),
            10),
            Pair(mutableListOf(1, 2, 4, 5, 6, 10), 3))
    }

    @Test
    fun `no pages in memory are useless`() {
        Assertions.assertEquals(processOneOPT(
            mutableListOf(1, 2, 3, 4, 5, 6),
            6,
            listOf(5, 2, 1, 6, 3, 4, 2, 4, 5),
            10),
            Pair(mutableListOf(1, 2, 3, 5, 6, 10), 4))
    }
}

class FindOptimalTests {
    @Test
    fun `normal situation`() {
        Assertions.assertEquals(findOptimal(mutableListOf(1, 2, 3, 4, 5, 6), listOf(5, 2, 1, 6, 4, 2, 5)),
            2)
    }
}