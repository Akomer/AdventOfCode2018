package adventOfCode2018

import java.io.File
import kotlin.math.abs

class Day1 {

    fun solve() {
        val input = File("input/day1.txt").readLines().map { it.toInt() }

        val sumOfAllFreq = input.sum()

        println("Day1 Part1: $sumOfAllFreq")

        var s = 0
        val subSumList = mutableListOf<Int>()
        input.forEach {
            s += it
            if (s in subSumList) {
                println("Day1 Part2: $s")
                return
            }
            subSumList.add(s)
        }

        var minMulti = Int.MAX_VALUE
        var result = 0
        var resMinIndex = Int.MAX_VALUE
        for ((xIndex, x) in subSumList.withIndex()) {
            for (yIndex in xIndex + 1..subSumList.lastIndex) {
                val y = subSumList[yIndex]
                if ((x - y) % sumOfAllFreq == 0) {
                    val multi = (x - y) / sumOfAllFreq
                    val absMulti = abs(multi)
                    val resIndex = if (multi > 0) yIndex else xIndex
                    val resultCandidate = if (multi > 0) x else y
                    if (absMulti < minMulti) {
                        minMulti = absMulti
                        result = resultCandidate
                        resMinIndex = resIndex
                    } else if (absMulti == minMulti && resIndex < resMinIndex) {
                        resMinIndex = resIndex
                        result = resultCandidate
                    }
                }
            }
        }
        println("Day1 Part2: $result")
    }
}