const val memorySize = 10
val pages = listOf(1, 5, 12, 3 , 5, 2, 4, 6, 7, 8, 10, 1, 9, 8, 11, 3, 13, 12, 14, 15)

fun main() {
    val memory = IntArray(memorySize) {-1}
    print(processAll(memory, pages, "OPT"))
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