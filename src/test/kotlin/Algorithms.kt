import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProcessOneFIFOTests {
    @Test
    fun `queue contains page and isn't full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneFIFO(
            7,
            3),
            3
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `memory contains page and is full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneFIFO(
            6,
            3),
            3
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `memory doesn't contain page and isn't full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneFIFO(
            7,
            10),
            -1
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 3, 4, 5, 6, 10))
    }

    @Test
    fun `memory doesn't contain page and is full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneFIFO(
            6,
            10),
            1
        )
        Assertions.assertEquals(memory, mutableListOf(2, 3, 4, 5, 6, 10))
    }
}

class ProcessOneLRUTests {
    @Test
    fun `memory contains page and isn't full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneLRU(
            7,
            3),
            3
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 4, 5, 6, 3))
    }

    @Test
    fun `memory contains page and is full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneLRU(
            6,
            3),
            3
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 4, 5, 6, 3))
    }

    @Test
    fun `memory doesn't contain page and isn't full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneLRU(
            7,
            10),
            -1
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 3, 4, 5, 6, 10))
    }

    @Test
    fun `memory doesn't contain page and is full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneLRU(
            6,
            10),
            1
        )
        Assertions.assertEquals(memory, mutableListOf(2, 3, 4, 5, 6, 10))
    }
}

class ProcessOneOPTTests {
    @Test
    fun `memory contains page and isn't full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneOPT(
            7,
            listOf(3, 5, 2, 1, 6, 4, 2, 5),
            3),
            3
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `memory contains page and is full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneOPT(
            6,
            listOf(3, 5, 2, 1, 6, 4, 2, 5),
            3),
            3
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `memory doesn't contain page and isn't full`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneOPT(
            7,
            listOf(10, 5, 2, 1, 6, 4, 2, 5),
            10),
            -1
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 3, 4, 5, 6, 10))
    }

    @Test
    fun `one page in memory is useless`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneOPT(
            6,
            listOf(5, 2, 1, 6, 4, 2, 5),
            10),
            3
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 4, 5, 6, 10))
    }

    @Test
    fun `no pages in memory are useless`() {
        val memory = mutableListOf(1, 2, 3, 4, 5, 6)
        Assertions.assertEquals(memory.processOneOPT(
            6,
            listOf(5, 2, 1, 6, 3, 4, 2, 4, 5),
            10),
            4
        )
        Assertions.assertEquals(memory, mutableListOf(1, 2, 3, 5, 6, 10))
    }
}

class FindOptimalTests {
    @Test
    fun `normal situation`() {
        Assertions.assertEquals(findOptimal(mutableListOf(1, 2, 3, 4, 5, 6), listOf(5, 2, 1, 6, 4, 2, 5)),
            2)
    }
}