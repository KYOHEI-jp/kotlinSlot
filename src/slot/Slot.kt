package slot

class Slot {

    private val reelL: Reel = Reel()
    private val reelC: Reel = Reel()
    private val reelR: Reel = Reel()

    /**
     * 全リールの抽選
     */
    fun lottery() {
        reelL.lottery()
        reelC.lottery()
        reelR.lottery()
    }

    /**
     * ボーナスか
     */
    fun isBonus(): Boolean = reelL.deme == reelC.deme && reelC.deme == reelR.deme

    /**
     * ボーナス時の出目を返す
     */
    private fun getBonusDeme(): Int {
        if (!isBonus()) {
            return -1
        }
        return reelL.deme
    }

    /**
     * ボーナス時にメダルをx倍にして返す
     * @param medal 現在メダル枚数
     * @return 計算後のメダル枚数
     */
    fun calcBonusMedal(medal: Int): Int = medal * getBonusMagnification()

    /**
     * ボーナス倍率を返す
     */
    fun getBonusMagnification(): Int = when {
        !isBonus() -> 1
        getBonusDeme() == 7 -> 10
        getBonusDeme() == 9 -> 5
        else -> 3
    }

    /**
     * 出目を表示する
     * @param rotateCount 回転数
     */
    fun displayDeme(rotateCount: Int) {
       println("%d回目[ %d | %d | %d ]".format(rotateCount, reelL.deme, reelC.deme, reelR.deme))
    }
}