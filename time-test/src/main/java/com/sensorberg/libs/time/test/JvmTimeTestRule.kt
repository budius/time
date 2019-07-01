package com.sensorberg.libs.time.test

import com.sensorberg.libs.time.Time
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class JvmTimeTestRule : TestWatcher() {

	override fun starting(description: Description?) {
		super.starting(description)
		Time.setProvider(JvmTimeProvider)
	}

	override fun finished(description: Description?) {
		Time.setProvider(null)
		super.finished(description)
	}

	object JvmTimeProvider : Time.TimeProvider {
		override fun getClockTime() = System.currentTimeMillis()
		override fun getElapsedTime() = System.nanoTime() / 1_000_000
	}

}