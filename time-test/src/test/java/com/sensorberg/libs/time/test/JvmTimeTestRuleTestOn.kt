package com.sensorberg.libs.time.test

import com.sensorberg.libs.time.Time
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

}