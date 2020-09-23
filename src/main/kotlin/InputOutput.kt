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