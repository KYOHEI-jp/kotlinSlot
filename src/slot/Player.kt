package slot

import kotlin.concurrent.thread

fun main() {
    thread {
        async()
    }
}

private fun async() {

    // スロットを作成する
    val slot = Slot()

    // 最大100回回す
    val maxRotate = 100

    val myMedal = MyMedal(medal = 5000)

    for (i in 0 until maxRotate) {

        //ベットする
        val isBet = myMedal.bet()
        //メダル不足
        if (!isBet) {
            println("メダルがたりません。終了します.")
            return
        }
        //抽選する
        slot.lottery()
        //表示する
        slot.displayDeme(rotateCount = i)
        //ボーナス
        if (slot.isBonus()) {
            println("ボーナス!")
            myMedal.medal = slot.calcBonusMedal(medal = myMedal.medal)

            //ボーナス倍率取得
            val bonusMagnification = slot.getBonusMagnification()
            println("メダルが${bonusMagnification}倍になりました。")
            //1秒停止
            Thread.sleep(1000)
        }

        // メダル表示
        myMedal.display()
        // 0.3秒停止
        //Thread.sleep(300)
    }
}