package jp.techacademy.cole.capri.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val value1 = intent.getDoubleExtra("VALUE1", 0.0)
        val value2 = intent.getDoubleExtra("VALUE2", 0.0)
        val tapButton = intent.getStringExtra("TAPBUTTON")

        var calcResult = 0.0
        when (tapButton) {
            "plus" -> calcResult = value1 + value2
            "minus" -> calcResult = value1 - value2
            "multiply" -> calcResult = value1 * value2
            "divide" -> calcResult = value1 / value2
        }

        calcresult_TextView.text = calcResult.toString()
    }
}