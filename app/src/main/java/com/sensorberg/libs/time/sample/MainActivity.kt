package com.sensorberg.libs.time.sample

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sensorberg.libs.time.Time

class MainActivity : AppCompatActivity() {

	private val elapsed = Time.elapsed()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val linearLayout = findViewById<LinearLayout>(R.id.root)!!
		findViewById<Button>(R.id.button)!!.setOnClickListener {
			val textView = TextView(this)
			val now = Time.getEpochTime()
			val tag = "Count ${linearLayout.childCount}"
			val elapsed = elapsed.lap(tag)
			textView.text = "epoch ${now}ms :: $tag = $elapsed"
			linearLayout.addView(textView)
		}

	}

}
