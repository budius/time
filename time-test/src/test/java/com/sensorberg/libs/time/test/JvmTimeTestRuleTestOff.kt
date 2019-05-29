package com.sensorberg.libs.time.test

import com.sensorberg.libs.time.Time
import org.junit.Test

class JvmTimeTestRuleTestOff {

	@Test(expected = RuntimeException::class)
	fun crash_because_we_did_not_apply_the_rule() {
		Time.getEpochTime()
		Time.getElapsedTime()
	}

}