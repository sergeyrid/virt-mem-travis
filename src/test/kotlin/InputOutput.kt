import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetInputTests {
    @Test
    fun `single input`() {
        val inputFile = "src/test/kotlin/input1.txt"
        val actual = listOf(
            InputData(5, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        )
        Assertions.assertEquals(getInput(inputFile), actual)
    }

    @Test
    fun `multiple inputs`() {
        val inputFile = "src/test/kotlin/input2.txt"
        val actual = listOf(
            InputData(31, listOf(1, 8, 3, 41, 41, 19, 79, 2, 37, 76, 71, 45, 67, 6,
                22, 67, 43, 56, 57, 33, 5, 50, 8, 80, 8, 27, 2, 77, 40, 37, 1, 79, 66, 57, 73, 49, 11,
                31, 80, 26, 73, 39, 48, 15, 66, 23, 64, 51, 82, 5, 69, 81, 69, 62, 67, 21, 31, 59, 6,
                36, 37, 39, 5, 57, 23, 68, 18, 38, 13, 75, 25, 69, 50, 45, 4, 37, 12, 18, 28, 78, 1, 17, 3)),
            InputData(5, listOf(1, 6, 2, 5, 3, 2, 5, 6, 2, 1, 7, 3, 3, 4, 5, 7, 1, 6, 2, 3, 5, 2,
                4, 1, 6, 7, 7, 3, 2, 1)),
            InputData(2, listOf(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3))
        )
        Assertions.assertEquals(getInput(inputFile), actual)
    }

    @Test
    fun `rubbish with one correct input`() {
        val inputFile = "src/test/kotlin/input3.txt"
        val actual = listOf(InputData(2, listOf(3, 4, 5)))
        Assertions.assertEquals(getInput(inputFile), actual)
    }

    @Test
    fun `empty file`() {
        val inputFile = "src/test/kotlin/input4.txt"
        val actual = emptyList<InputData>()
        Assertions.assertEquals(getInput(inputFile), actual)
    }
}
