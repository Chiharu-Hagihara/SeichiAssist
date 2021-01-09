package com.github.unchama.seichiassist.domain.explevel

import cats.kernel.Monoid
import com.github.unchama.generic.algebra.typeclasses.PositiveInt
import com.github.unchama.seichiassist.util.typeclass.HasMinimum

import scala.collection.Searching

/**
 * 経験値量のテーブル。
 *
 * @param internalTable 経験値の遷移を記述するSeq。
 *                      i番目の要素に、レベルi+1になるのに必要な経験値量が入る。
 *                      この列は単調増加であることが要求される。
 */
class ExpLevelTable[
  L: PositiveInt,
  ExpAmount: Ordering : HasMinimum
](private val internalTable: Vector[ExpAmount]) {

  private val order = implicitly[Ordering[ExpAmount]]

  import order._

  require({
    internalTable.sliding(2).forall { case Seq(x1, x2) =>
      x1 <= x2
    }
  }, "internalTable must be sorted")

  require(internalTable.nonEmpty)

  require({
    internalTable.head == HasMinimum[ExpAmount].minimum
  }, "first element of the table must be the minimum amount")

  def levelAt(expAmount: ExpAmount): L = PositiveInt[L].wrapPositive {
    internalTable.search(expAmount) match {
      case Searching.Found(foundIndex) => foundIndex + 1
      case Searching.InsertionPoint(insertionPoint) => insertionPoint
    }
  }

  def maxLevel: L = PositiveInt[L].wrapPositive {
    internalTable.size
  }

  /**
   * このテーブルを与えられたレベルまで延長するためのビルダーを返す。
   */
  def extendToLevel(level: L): ExtensionBuilder = ExtensionBuilder(level)

  case class ExtensionBuilder(extensionTarget: L) {
    /**
     * [[extensionTarget]] まで、レベルを1延長するごとに必要な経験値量を `exp` 増やすよう延長したテーブルを返す。
     */
    def withLinearIncreaseOf(exp: ExpAmount)
                            (implicit addition: Monoid[ExpAmount]): ExpLevelTable[L, ExpAmount] = {
      val lengthToFill = (PositiveInt[L].asInt(extensionTarget) - PositiveInt[L].asInt(maxLevel)) max 0
      val lastThreshold = internalTable.last
      val extension = Vector.iterate(lastThreshold, lengthToFill)(addition.combine(_, exp))

      new ExpLevelTable(internalTable.appendedAll(extension))
    }
  }

}
