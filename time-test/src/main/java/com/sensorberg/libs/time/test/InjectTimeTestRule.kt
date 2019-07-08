package com.sensorberg.libs.time.test

import com.sensorberg.libs.time.Time
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class InjectTimeTestRule : TestWatcher() {

	private var _timeResponse: InjectTimeResponse? = null

	val timeResponse: InjectTimeResponse
		get() = _timeResponse!!

	override fun starting(description: Description?) {
		super.starting(description)
		_timeResponse = InjectTimeResponse()
	}

	override fun finished(description: Description?) {
		_timeResponse!!.close()
		super.finished(description)
	}
}

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