import org.junit.jupiter.api.Test
import java.io.File
import kotlin.random.Random

const val inputFile = "data/genInput.txt"
const val maxMemorySize = 1000
const val maxExtraPages = 100
const val pagesMultiplier = 10

// Generates an input file with random input
class InputGenerator {
    @Test
    fun generator() {
        val n = Random.nextInt(1, maxMemorySize)
        File(inputFile).writeText("$n\n")
        val m = n + Random.nextInt(1, maxExtraPages)
        for (i in 1 until pagesMultiplier * m) {
            val page = Random.nextInt(1, m)
            File(inputFile).appendText("$page ")
        }
        File(inputFile).appendText("\n")
    }
}