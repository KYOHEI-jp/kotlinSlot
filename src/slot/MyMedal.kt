package slot

class MyMedal(
    /** 持ちメダル */
    var medal: Int

) {

    /**
     * ベットする
     * @return ベット成功したか
     */
    fun bet(): Boolean {
        //メダル不足時はベットさせない
        if (medal < 50) {
            return false
        }

        medal -= 50

        //ベット成功
        return true
    }

    /**
     * 持ちメダルを表示する
     */
    fun display() {
        println("メダル: $medal 枚")
    }
}