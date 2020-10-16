import java.io.File
import java.lang.Exception

fun main(args: Array<String>) {
    var fileNames = args
    while (fileNames.size < 2) {
        println("Please, try again")
        println("Pass input and output file names separated with a space:")
        fileNames = readLine().toString().split(' ').toTypedArray()
    }
    val (inputFile, outputFile) = Pair(fileNames[0], fileNames[1])
    val input = try {
        getInput(inputFile)
    } catch (e: Exception) {
        print("Input file could not be found")
        return
    }
    File(outputFile).writeText("") // Clear output file
    for (data in input) {
        val memory = IntArray(data.memorySize) {-1}.toList()
        printAll(memory, data.pages, outputFile)
    }
}

// Calls all 3 algorithms and prints the results
fun printAll(memory: List<Int>, pages: List<Int>, outputFile: String) {
    for (algo in Algorithms.values()) {
        val operations = processAny(memory, pages, algo)
        printResult(outputFile, operations, algo)
    }
}

// Returns the list of operations applied to memory
fun processAny(initialMemory: List<Int>, pages: List<Int>, algo: Algorithms): List<Operation>{
    val memory = initialMemory.toMutableList()
    val memoryStructure = mutableListOf<Int>()
    val operations = mutableListOf<Operation>()
    for (i in pages.indices) {
        val page = pages[i]
        val substPage = when (algo) {
            Algorithms.FIFO -> memoryStructure.processOneFIFO(memory.size, page)
            Algorithms.LRU -> memoryStructure.processOneLRU(memory.size, page)
            else -> memoryStructure.processOneOPT(memory.size, pages.subList(i, pages.size), page)
        }
        if (substPage == page) {
            operations.add(Operation(false, page))
        } else {
            val frame = memory.indexOf(substPage)
            memory[frame] = page
            operations.add(Operation(true, page, frame + 1))
        }
    }
    return operations
}

enum class Algorithms {
    FIFO,
    LRU,
    OPT
}

data class Operation (
    val secondType: Boolean = true,
    val page: Int = 0,
    val frame: Int = 0
)