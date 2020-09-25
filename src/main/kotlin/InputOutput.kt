import java.io.File
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException

fun getInput(inputFile: String): List<InputData> {
    val rawInput = File(inputFile).readLines()
    val input = mutableListOf<InputData>()
    for (i in rawInput.indices step 2) {
        try {
            input.add(InputData(
                rawInput[i].toInt(),
                rawInput[i + 1].split(' ').map { it.toInt() }
            ))
        }
        catch (e: NumberFormatException) { }
        catch (e: IndexOutOfBoundsException) { }
    }
    return input
}

fun printResult(outputFile: String, operations: List<String>, secondType: Int, algo: String) {
    val file = File(outputFile)
    val result = "$algo:\n$secondType operations of the second type\n" + operations.joinToString("\n") + "\n"
    file.appendText(result)
}

data class InputData (
    val memorySize: Int = 0,
    val pages: List<Int> = listOf()
)