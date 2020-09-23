// Returns the queue and a page, that was removed from memory (if none, returns -1)
fun processOne(queue: MutableList<Int>, memorySize: Int, page: Int): Pair<MutableList<Int>, Int> {
    var deletedPage = -1
    if (queue.contains(page)) {
        queue.remove(page)
    } else if (queue.size >= memorySize) {
        deletedPage = queue[0]
        queue.removeAt(0)
    }
    queue.add(page)
    return queue to deletedPage
}

fun processAll(memory: Array<Int>, pages: List<Int>): List<String> {
    var queue = mutableListOf<Int>()
    val operations = mutableListOf<String>()
    for (page in pages) {
        val result = processOne(queue, memory.size, page)
        queue = result.first
        val deletedPage = result.second
        memory[findFrame(deletedPage)] = page
        if (deletedPage == page) {
            operations.add("The page has already been loaded into memory")
        } else {
            operations.add("Frame number $deletedPage should be substituted")
        }
    }
    return operations
}