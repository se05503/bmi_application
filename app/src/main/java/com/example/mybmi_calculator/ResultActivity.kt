package com.example.mybmi_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // MainActivity 에서 Intent 를 통해 보낸 데이터를 해당 액티비티에서 받아야 함
        // defaultValue 값은 0을 넣으면 됨
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight",0)

        // BMI = 몸무게(kg)/키(m) X 키(m)
        // 정수로 안쓰고 보통 실수로 쓴다.
        var value = weight / (height/100.0).pow(2.0) // value 값은 text 이다.
        value = round(value*10)/10 // 소수점 첫째 짜리 까지 표시, 만약 둘째 짜리 까지면 value = round(value*100)/100 이라 하면 됨

        // 임시 값(초기 값) → 조건에 따라 값이 달라지기 때문에
        var resultText = ""
        var resImage = 0
        var resColor = 0

        if(value<18.5) {
            resultText="저체중"
            resImage = R.drawable.img_lv1
            resColor= Color.YELLOW
        } else if(value>=18.5 && value<23.0) { // 암기할 부분
            resultText="정상 체중"
            resImage=R.drawable.img_lv2
            resColor=Color.GREEN
        } else if(value>=23.0&&value<25.0) {
            resultText="과체중"
            resImage=R.drawable.img_lv3
            resColor=Color.BLACK
        } else if(value>=25.0 && value<30.0) {
            resultText="경도 비만"
            resImage=R.drawable.img_lv4
            resColor=Color.CYAN
        } else if(value>=30.0 && value<35.0) {
            resultText="중정도 비만"
            resImage=R.drawable.img_lv5
            resColor=Color.MAGENTA
        } else {
            resultText="고도비만"
            resImage=R.drawable.img_lv6
            resColor=Color.RED
        }

        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val btn_back = findViewById<Button>(R.id.btn_back)

        tv_resValue.text=value.toString()
        tv_resText.text = resultText
        tv_resText.setTextColor(resColor)
        iv_image.setImageResource(resImage)

        btn_back.setOnClickListener {
            finish()
        }

    }
}