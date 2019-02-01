import scala.collection.mutable.ListBuffer

object Solution77 {
  def combine(n: Int, k: Int): List[List[Int]] = {
    var result =  new ListBuffer[List[Int]]
    var tmp = new ListBuffer[Int]()

    def combineInternal (n: Int, k: Int, startValue: Int): Unit = {
      if (tmp.length == k) {
        result += tmp.toList
        return
      }

      startValue.until(n).foreach(i => {
        tmp += i + 1
        combineInternal(n, k, i + 1)
        tmp.remove(tmp.length - 1)
      })
    }
    combineInternal(n, k, 0)
    result.toList
  }
}