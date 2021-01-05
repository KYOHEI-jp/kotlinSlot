package slot

/**
 * リールクラス
 * @author Altonotes
 */
class Reel {


    var deme: Int = 0
    /**
     * リールの出目を抽選し、出目をセットする
     */
    fun lottery() {
        deme = (Math.random() * 9 + 1).toInt()
    }
}