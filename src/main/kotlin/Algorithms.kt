// Returns the queue and a page, that was removed from memory (if none, returns -1)
fun processOneFIFO(queue: MutableList<Int>, memorySize: Int, page: Int): Pair<MutableList<Int>, Int> {
    var substPage = -1
    when {
        queue.contains(page) -> substPage = page
        queue.size < memorySize -> queue.add(page)
        else -> {
            substPage = queue[0]
            queue.removeAt(0)
            queue.add(page)
        }
    }
    return queue to substPage
}

// Return is identical to FIFO function
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


// Return is identical to FIFO function
fun processOneOPT(queue: MutableList<Int>, memorySize: Int, pages: List<Int>, page: Int): Pair<MutableList<Int>, Int> {
    var substPage = -1
    when {
        queue.contains(page) -> substPage = page
        queue.size < memorySize -> queue.add(page)
        else -> {
            val index = findOptimal(queue, pages)
            substPage = queue[index]
            queue.removeAt(index)
            queue.add(page)
        }
    }
    return queue to substPage
}

// This is used by OPT algorithm
// Returns the index of an optimal page to be removed from the queue
fun findOptimal(queue: MutableList<Int>, pages: List<Int>): Int {
    val nextUse = IntArray(queue.size) // For each page in the queue saves how soon it will be used
    for (i in queue.indices) {
        val page = queue[i]
        nextUse[i] = pages.indexOf(page)
        if (nextUse[i] == -1) {     // The page is not used, so it will be used later than
            nextUse[i] = pages.size // any page in the 'pages' array
        }
    }
    val max = nextUse.max()
    return if (max != null) {
        nextUse.indexOf(max)
    } else {
        throw Exception("Optimal solution could not be found")
    }
}