package com.sensorberg.libs.time.test

import com.sensorberg.libs.time.Time

class InjectTimeResponse : Time.TimeProvider {

	var clockTimeResponse = 0L
	var elapsedTimeResponse = 0L

	init {
		Time.setProvider(this)
	}

	override fun getClockTime() = clockTimeResponse
	override fun getElapsedTime() = elapsedTimeResponse

	fun close() {
		Time.setProvider(null)
	}
}