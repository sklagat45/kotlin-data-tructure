fun ArrayList<Int>.findFirstValue(value: Int):Int? {
    var low = 0
    var high = this.size - 1

    var findFirstValue: Int? = null
    while (low <= high) {
        var mid: Int = (low + high) / 2
        if (value <= this[mid]) {
            findFirstValue = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return findFirstValue

}

fun ArrayList<Int>.findIndices(value: Int): IntRange? {
    val startIndex = findFirstValue(value) ?: return null
    val endIndex = findFirstValue(value+1) ?: return null

    return startIndex until endIndex

}



fun main(){
    val sorted = arrayListOf(1,3,6,42,741,20202)
    println(sorted.binarySearch (741))
    println(sorted.reverse())


    val array = arrayListOf(1,2,2,2,2,3,3,3,4,5,5)
    println(array.findFirstValue (5))
    println(array.findIndices (5))


}