import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GetInputTests {
    @Test
    fun `single input`() {
        Assertions.assertEquals(getInput("src/test/kotlin/input1.txt"),
            listOf(InputData(5, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))))
    }
}
