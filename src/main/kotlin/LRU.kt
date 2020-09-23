// Returns the list of operations, applied to memory and a number of answers of the second type
fun processAllLRU(memory: IntArray, pages: List<Int>): Pair<List<String>, Int> {
    var queue = mutableListOf<Int>()
    val operations = mutableListOf<String>()
    var secondType = 0
    for (page in pages) {
        val result = processOneLRU(queue, memory.size, page)
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

// Returns the queue and a page, that was removed from memory (if none, returns -1)
fun processOneLRU(queue: MutableList<Int>, memorySize: Int, page: Int): Pair<MutableList<Int>, Int> {
    var substPage = -1
    if (queue.contains(page)) {
        substPage = page
        queue.remove(page)
    } else if (queue.size >= memorySize) {
        substPage = queue[0]
        queue.removeAt(0)
    }
    queue.add(page)
    return queue to substPage
}

