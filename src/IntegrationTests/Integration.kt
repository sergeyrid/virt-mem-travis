import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class IntegrationTests {
    @Test
    fun `generated tests`() {
        for (i in 1..10) {
            main(arrayOf("src/IntegrationTests/input$i.txt", "src/IntegrationTests/tmpOutput.txt"))
            val output = File("src/IntegrationTests/tmpOutput.txt").readText()
            val actual = File("src/IntegrationTests/output$i.txt").readText()
            Assertions.assertEquals(output, actual)
        }
    }

    @Test
    fun `rubbish with one correct input`() {
        main(arrayOf("src/IntegrationTests/input11.txt", "src/IntegrationTests/tmpOutput.txt"))
        val output = File("src/IntegrationTests/tmpOutput.txt").readText()
        val actual = File("src/IntegrationTests/output11.txt").readText()
        Assertions.assertEquals(output, actual)
    }
}