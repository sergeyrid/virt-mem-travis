import org.junit.jupiter.api.Test
import java.io.File
import kotlin.random.Random

const val inputFile = "data/genInput.txt"

class InputGenerator {
    @Test
    fun generator() {
        val n = Random.nextInt(1, 1000)
        File(inputFile).writeText("$n\n")
        val m = n + Random.nextInt(1, 100)
        for (i in 1 until 10 * m) {
            val page = Random.nextInt(1, m)
            File(inputFile).appendText("$page ")
        }
        File(inputFile).appendText("\n")
    }
}