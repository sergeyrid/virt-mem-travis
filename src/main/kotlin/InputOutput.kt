import java.io.File

fun getInput(inputFile: String): List<InputData> {
    val rawInput = File(inputFile).readLines()
    val input = mutableListOf<InputData>()
    for (i in rawInput.indices step 2) {
        input.add(InputData(
            rawInput[i].toInt(),
            rawInput[i + 1].split(' ').map { it.toInt() }
        ))
    }
    return input
}