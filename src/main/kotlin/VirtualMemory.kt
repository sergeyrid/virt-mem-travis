import java.io.File
import java.lang.Exception

fun main(args: Array<String>) {
    val (inputFile, outputFile) = try {
        Pair(args[0], args[1])
    } catch (e: Exception) {
        throw Exception("Input and output file names were not passed")
    }
    val input = try {
        getInput(inputFile)
    } catch (e: Exception) {
        throw Exception("Input file was not found")
    }
    File(outputFile).writeText("") // Clear output file
    for (data in input) {
        File(outputFile).appendText("////////////////////////////////////////////////////\n")
        val memory = IntArray(data.memorySize) {-1}.toList()
        printAll(memory, data.pages, outputFile)
    }
}

// Calls all 3 algorithms and prints the results
fun printAll(memory: List<Int>, pages: List<Int>, outputFile: String) {
    for (algo in Algorithms.values()) {
        val (operations, secondType) = processAll(memory, pages, algo)
        printResult(outputFile, operations, secondType, algo)
    }
}

// Returns the list of operations, applied to memory and a number of answers of the second type
fun processAll(initialMemory: List<Int>, pages: List<Int>, algo: Algorithms): Pair<List<String>, Int> {
    val memory = initialMemory.toMutableList()
    var queue = mutableListOf<Int>()
    val operations = mutableListOf<String>()
    var secondType = 0
    for (i in pages.indices) {
        val page = pages[i]
        val result = callAlgorithm(queue, memory.size, i, pages, algo)
        queue = result.first
        val substPage = result.second
        if (substPage == page) {
            operations.add("Page $page has already been loaded into memory")
        } else {
            val frame = memory.indexOf(substPage)
            memory[frame] = page
            operations.add("Frame ${frame + 1} should be substituted with page $page")
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
                  algo: Algorithms): Pair<MutableList<Int>, Int> {
    val page = pages[pageIndex]
    return when (algo) {
        Algorithms.FIFO -> processOneFIFO(queue, limit, page)
        Algorithms.LRU -> processOneLRU(queue, limit, page)
        else -> processOneOPT(queue, limit, pages.subList(pageIndex, pages.size), page)
    }
}

enum class Algorithms {
    FIFO,
    LRU,
    OPT
}