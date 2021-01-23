package com.github.unchama.datarepository.template

import cats.{Contravariant, Monad}
import com.github.unchama.generic.RefDict

import java.util.UUID

/**
 * データレポジトリの初期化処理を記述するオブジェクト。
 *
 * マインクラフトのサーバーの仕様として、プレーヤーがサーバーに実際に参加する前に
 * プレーヤーのUUID/名前ペアを受け取れることになっている。
 *
 * このオブジェクトが記述するのは、そのような状況下において
 *  - ログイン処理後にUUID/名前を受け取り次第 [[R]] を生成する
 *
 * ようなデータリポジトリの処理である。
 */
trait SinglePhasedRepositoryInitialization[F[_], R] {

  /**
   * 参加したプレーヤーのUUID/名前から[[R]]を生成する作用。
   *
   * [[R]] が何らかの理由により生成できなかった場合、[[PrefetchResult.Failed]]を返す可能性がある。
   */
  def prepareData(uuid: UUID, name: String): F[PrefetchResult[R]]

  import cats.implicits._

  def extendPreparation[S](f: (UUID, String) => R => F[S])(implicit F: Monad[F]): SinglePhasedRepositoryInitialization[F, S] =
    (uuid, name) => prepareData(uuid, name) >>= (_.traverse(f(uuid, name)))

}

object SinglePhasedRepositoryInitialization {

  import cats.implicits._

  def fromRefDict[F[_] : Monad, R](refDict: RefDict[F, (UUID, String), R])
                                  (getDefaultValue: F[R]): SinglePhasedRepositoryInitialization[F, R] =
    (uuid, name) => refDict.read((uuid, name)).flatMap {
      case Some(value) => Monad[F].pure(value)
      case None => getDefaultValue.map(PrefetchResult.Success.apply)
    }

  def fromUuidRefDict[F[_] : Monad, R](refDict: RefDict[F, UUID, R])
                                      (getDefaultValue: F[R]): SinglePhasedRepositoryInitialization[F, R] =
    fromRefDict(Contravariant[RefDict[F, *, R]].contramap(refDict)(_._1))(getDefaultValue)

}
