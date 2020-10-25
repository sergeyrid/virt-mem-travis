import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class IntegrationTests {
    @Test
    fun test1() {
        main(arrayOf("src/IntegrationTests/input1.txt", "src/IntegrationTests/tmpOutput.txt"))
        val output = File("src/IntegrationTests/tmpOutput.txt").readText()
        val actual = File("src/IntegrationTests/output2.txt").readText()
        Assertions.assertEquals(output, actual)
    }

    @Test
    fun test2() {
        main(arrayOf("src/IntegrationTests/input2.txt", "src/IntegrationTests/tmpOutput.txt"))
        val output = File("src/IntegrationTests/tmpOutput.txt").readText()
        val actual = File("src/IntegrationTests/output2.txt").readText()
        Assertions.assertEquals(output, actual)
    }

    @Test
    fun test3() {
        main(arrayOf("src/IntegrationTests/input3.txt", "src/IntegrationTests/tmpOutput.txt"))
        val output = File("src/IntegrationTests/tmpOutput.txt").readText()
        val actual = File("src/IntegrationTests/output3.txt").readText()
        Assertions.assertEquals(output, actual)
    }

    @Test
    fun `rubbish with one correct input`() {
        main(arrayOf("src/IntegrationTests/input4.txt", "src/IntegrationTests/tmpOutput.txt"))
        val output = File("src/IntegrationTests/tmpOutput.txt").readText()
        val actual = File("src/IntegrationTests/output4.txt").readText()
        Assertions.assertEquals(output, actual)
    }
}