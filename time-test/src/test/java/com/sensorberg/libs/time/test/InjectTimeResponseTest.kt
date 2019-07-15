package com.sensorberg.libs.time.test

import com.sensorberg.libs.time.Time
import org.junit.Assert.assertEquals
import org.junit.Test

class InjectTimeResponseTest {

	@Test
	fun returned_values_are_from_InjectTimeResponse() {
		val injectTime = InjectTimeResponse()
		injectTime.clockTimeResponse = 1L
		injectTime.elapsedTimeResponse = 2L
		assertEquals(1L, Time.getEpochTime())
		assertEquals(2L, Time.getElapsedTime())
		injectTime.close()
	}

	@Test
	fun returned_values_are_from_InjectTimeResponse_using_lambda() {
		injectTime {
			clockTimeResponse = 1L
			elapsedTimeResponse = 2L
			assertEquals(1L, Time.getEpochTime())
			assertEquals(2L, Time.getElapsedTime())
		}
	}

	@Test
	fun measureElapsedTime() {
		val injectTime = InjectTimeResponse()
		injectTime.elapsedTimeResponse = 1L

		val elapsed = Time.elapsed()
		injectTime.elapsedTimeResponse = 11L
		assertEquals(10L, elapsed.lap("first"))
		injectTime.elapsedTimeResponse = 21L
		assertEquals(20L, elapsed.lap("second"))
		Time.setProvider(null)

		assertEquals(10L, elapsed.laps["first"])
		assertEquals(20L, elapsed.laps["second"])
	}

}