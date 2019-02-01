import org.scalatest.FunSuite
import Solution77.combine

class Solution77Test extends FunSuite {

  test("testCombine") {
    assert(
      combine(4, 2) ==
        List(
          List(1, 2),
          List(1, 3),
          List(1, 4),
          List(2, 3),
          List(2, 4),
          List(3, 4)
        )
    )

  }

}
