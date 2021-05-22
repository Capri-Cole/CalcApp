package jp.techacademy.cole.capri.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus_button.setOnClickListener(this)
        minus_button.setOnClickListener(this)
        multiply_button.setOnClickListener(this)
        divide_button.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        //入力チェック
        if (TextUtils.isEmpty(editText1.text.toString())) {
            dispMessage(v, "値1が未入力です。")
            return
        } else if (TextUtils.isEmpty(editText2.text.toString())) {
            dispMessage(v, "値2が未入力です。")
            return
        }

        //入力された値を小数点型で格納
        val value1 = editText1.text.toString().toDouble()
        val value2 = editText2.text.toString().toDouble()

        //割り算チェック
        if (v.id == R.id.divide_button && value2.toInt() == 0) {
            dispMessage(v, "値2が0の場合÷はできません。")
            return
        }

        //押されたボタンを変数に設定
        var tapButton = ""
        when (v.id) {
            R.id.plus_button -> tapButton = "plus"
            R.id.minus_button -> tapButton = "minus"
            R.id.multiply_button -> tapButton = "multiply"
            R.id.divide_button -> tapButton = "divide"
        }

        //画面遷移、渡すデータ設定
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("VALUE1", value1)
        intent.putExtra("VALUE2", value2)
        intent.putExtra("TAPBUTTON", tapButton)
        startActivity(intent)

    }

    //メッセージ表示処理
    private fun dispMessage(v: View, message: String) {
        Snackbar.make(v, message, Snackbar.LENGTH_SHORT).show()
    }
}