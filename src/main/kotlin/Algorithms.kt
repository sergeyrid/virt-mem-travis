// Returns a page, that was removed from memory (if none, returns -1)
fun MutableList<Int>.processOneFIFO(memorySize: Int, page: Int): Int {
    var substPage = -1
    when {
        this.contains(page) -> substPage = page
        this.size < memorySize -> this.add(page)
        else -> {
            substPage = this[0]
            this.removeAt(0)
            this.add(page)
        }
    }
    return substPage
}

// Return is identical to FIFO function
fun MutableList<Int>.processOneLRU(memorySize: Int, page: Int): Int {
    var substPage = -1
    if (this.contains(page)) {
        substPage = page
        this.remove(page)
    } else if (this.size >= memorySize) {
        substPage = this[0]
        this.removeAt(0)
    }
    this.add(page)
    return substPage
}

// Return is identical to FIFO function
fun MutableList<Int>.processOneOPT(memorySize: Int, pages: List<Int>, page: Int): Int {
    var substPage = -1
    when {
        this.contains(page) -> substPage = page
        this.size < memorySize -> this.add(page)
        else -> {
            val index = findOptimal(this, pages)
            substPage = this[index]
            this.removeAt(index)
            this.add(page)
        }
    }
    return substPage
}

// This is used by OPT algorithm
// Returns the index of an optimal page to be removed from the queue
fun findOptimal(queue: List<Int>, pages: List<Int>): Int {
    val nextUse = IntArray(queue.size) // For each page in the queue saves how soon it will be used
    for (i in queue.indices) {
        val page = queue[i]
        nextUse[i] = pages.indexOf(page)
        if (nextUse[i] == -1) {     // The page is not used, so it will be used later than any other page
            nextUse[i] = pages.size
        }
    }
    val max = nextUse.max()
    return if (max != null) {
        nextUse.indexOf(max)
    } else {
        print("Something went wrong when applying OPT algorithm")
        0
    }
}