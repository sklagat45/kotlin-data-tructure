/*
 * Copyright (c) 2020 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

fun <T : Comparable<T>> ArrayList<T>.binarySearch(value: T): Int? {
    var low = 0
    var high = this.size - 1
    
    while (low <= high) {
        var middle: Int = (low + high) / 2
        if (value == this[middle]) {
            return middle
        } else if (value < this[middle]) {
            high = middle - 1
        } else { // value > this[middle]
            low = middle + 1
        }
    }

    return null
}

fun <T : Comparable<T>> ArrayList<T>.binarySearchRecursive(
  value: T,
  range: IntRange = indices
): Int? {
  if (range.first > range.last) {
    return null
  }

  val size = range.last - range.first + 1
  val middle = range.first + size / 2

  return when {
    this[middle] == value -> middle
    this[middle] > value -> binarySearchRecursive(value, range.first until middle)
    else -> binarySearchRecursive(value, (middle + 1)..range.last)
  }
}


