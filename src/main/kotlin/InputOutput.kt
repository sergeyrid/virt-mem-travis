import java.io.File
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException

fun getInput(inputFile: String): List<InputData> {
    val rawInput = File(inputFile).readLines().map { it.trim() }
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

fun printResult(outputFile: String, operations: List<Operation>, algo: Algorithms) {
    val file = File(outputFile)
    var secondType = 0
    file.appendText("/////////////////////////////////\n")
    file.appendText("$algo\n")
    for (operation in operations) {
        if (operation.secondType) {
            file.appendText("Frame ${operation.frame} should be substituted with page ${operation.page}\n")
            ++secondType
        } else {
            file.appendText("Page ${operation.page} has already been loaded into memory\n")
        }
    }
    file.appendText("$secondType operations of the second type\n")
}

data class InputData (
    val memorySize: Int = 0,
    val pages: List<Int> = listOf()
)