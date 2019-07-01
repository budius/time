package com.sensorberg.libs.time.test

import com.sensorberg.libs.time.Time
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class JvmTimeTestRuleTestOn {

	@get:Rule
	val testRule = JvmTimeTestRule()

	@Test
	fun do_not_crash_because_we_apply_the_rule() {
		Time.getEpochTime()
		Time.getElapsedTime()
	}

	@Test fun elapsed_time_properly_counts_time() {
		val tested = Time.elapsed()
		Thread.sleep(100)
		val elapsed = tested.elapsed()
		assertTrue(elapsed > 90)
		assertTrue(elapsed < 110)
	}

}