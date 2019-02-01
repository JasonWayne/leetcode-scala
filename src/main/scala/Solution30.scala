import scala.collection.mutable

/**
  * 30. Substring with Concatenation of All Words
  */
object Solution30 {

  def findSubstring(s: String, words: Array[String]): List[Int] = {
    if (null == words || words.length == 0) {
      return List()
    }

    val initialMap = mutable.HashMap[String, Int]()
    val eachWordLength = words.head.length
    val totalWords = words.length
    words.foreach(word => initialMap.update(word, initialMap.getOrElseUpdate(word, 0) + 1))
    val groundTrueMap = initialMap.toMap
    val indexList = mutable.ListBuffer[Int]()

    var countDownMap = mutable.Map(groundTrueMap.toSeq: _*)
    0.to(s.length).foreach(i => {
      countDownMap = mutable.Map(groundTrueMap.toSeq: _*)
      0.to(totalWords).takeWhile(j => {
        val tmpStr = s.slice(i + eachWordLength * j, i + eachWordLength * j + eachWordLength)
        val remained = countDownMap.getOrElse[Int](tmpStr, 0)
        if (remained == 0) {
          false
        } else {
          val newValue = countDownMap.getOrElse[Int](tmpStr, 0) - 1
          countDownMap.update(tmpStr, newValue)
          if (newValue == 0) {
            countDownMap.remove(tmpStr)
            if (countDownMap.isEmpty) {
              indexList += i
            }
          }
          true
        }
      })
    })

    indexList.toList
  }

}