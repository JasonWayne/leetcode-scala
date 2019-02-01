import Solution30.findSubstring
import org.scalatest.FunSuite

class Solution30Test extends FunSuite {

  test("testFindSubstring") {
    assert(
      findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", List("fooo","barr","wing","ding","wing").toArray) == List(13))

    assert(
      findSubstring("barfoothefoobarman", List("foo","bar").toArray) == List(0, 9)
    )
  }

}
