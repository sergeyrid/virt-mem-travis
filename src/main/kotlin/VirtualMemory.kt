import java.io.File

const val inputFile = "data/input.txt"
const val outputFile = "data/output.txt"

fun main() {
    val input = getInput(inputFile)
    File(outputFile).writeText("") // clear output file
    for (data in input) {
        // TODO Refactor this awful code
        var memory = IntArray(data.memorySize) { -1 }
        val (operationsFIFO, secondTypeFIFO) = processAll(memory, data.pages, "FIFO")
        printResult(outputFile, operationsFIFO, secondTypeFIFO, "FIFO")
        memory = IntArray(data.memorySize) { -1 }
        val (operationsLRU, secondTypeLRU) = processAll(memory, data.pages, "LRU")
        printResult(outputFile, operationsLRU, secondTypeLRU, "LRU")
        memory = IntArray(data.memorySize) { -1 }
        val (operationsOPT, secondTypeOPT) = processAll(memory, data.pages, "OPT")
        printResult(outputFile, operationsOPT, secondTypeOPT, "OPT")
    }
}

// Returns the list of operations, applied to memory and a number of answers of the second type
fun processAll(memory: IntArray, pages: List<Int>, algo: String): Pair<List<String>, Int> {
    var queue = mutableListOf<Int>()
    val operations = mutableListOf<String>()
    var secondType = 0
    for (i in pages.indices) {
        val page = pages[i]
        val result = callAlgorithm(queue, memory.size, i, pages, algo)
        queue = result.first
        val substPage = result.second
        if (substPage == page) {
            operations.add("The page has already been loaded into memory")
        } else {
            val frame = memory.indexOf(substPage)
            memory[frame] = page
            operations.add("Frame number ${frame + 1} should be substituted")
            ++secondType
        }
    }
    return operations to secondType
}

// Calls processOne function of an algorithm specified with the 'algo' parameter
fun callAlgorithm(queue: MutableList<Int>,
                  limit: Int,
                  pageIndex: Int,
                  pages: List<Int>,
                  algo: String): Pair<MutableList<Int>, Int> {
    val page = pages[pageIndex]
    return when (algo) {
        "FIFO" -> processOneFIFO(queue, limit, page)
        "LRU" -> processOneLRU(queue, limit, page)
        else -> processOneOPT(queue, limit, pages.subList(pageIndex, pages.size), page)
    }
}