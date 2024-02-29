package com.example.mybmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val submitButton = findViewById<Button>(R.id.btn_check)
        // submitButton 이 눌렸을 때, heightEditText 의 value 와 weightEditText 의 value 를 다음 activity 화면에 넘겨줘야 한다.

        submitButton.setOnClickListener {

            //사용자가 신장이나 무게를 입력하지 않았을 때의 예외처리 발생
            if(heightEditText.text.isEmpty()) {
                //알림 문구 메세지 띄우기
                Toast.makeText(this, "신장을 입력해주세요!", Toast.LENGTH_SHORT).show()
                //데이터를 인텐트에 넘기면 안됨
                return@setOnClickListener
            }

            if(weightEditText.text.isEmpty()) {
                Toast.makeText(this, "체중을 입력해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height : Int = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText.text.toString().toInt()

            //activity에서 activity로 데이터를 넘겨줄 때 : Intent 사용
            // MainActivity 에서 ResultActivity를 부르는 과정
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}