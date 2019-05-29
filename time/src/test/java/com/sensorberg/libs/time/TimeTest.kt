package com.sensorberg.libs.time

import org.junit.Assert.assertEquals
import org.junit.Test

class TimeTest {

	@Test
	fun getClockTime() {
		assertEquals(Time.getEpochTime(), System.currentTimeMillis())
	}

	@Test
	fun getElapsedTime() {
		Time.setProvider(object : Time.TimeProvider {
			override fun getClockTime(): Long = 1L
			override fun getElapsedTime(): Long = 2L
		})
		assertEquals(Time.getElapsedTime(), 2L)
		Time.setProvider(null)
	}

	@Test
	fun measureElapsedTime() {
		var response = 1L
		Time.setProvider(object : Time.TimeProvider {
			override fun getClockTime(): Long = System.currentTimeMillis()
			override fun getElapsedTime(): Long = response
		})
		val elapsed = Time.elapsed()
		response = 11L
		assertEquals(10L, elapsed.lap("first"))
		response = 21L
		assertEquals(20L, elapsed.lap("second"))
		Time.setProvider(null)

		assertEquals(10L, elapsed.laps["first"])
		assertEquals(20L, elapsed.laps["second"])
	}

}