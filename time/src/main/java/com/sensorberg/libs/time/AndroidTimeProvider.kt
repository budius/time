package com.sensorberg.libs.time

import android.os.SystemClock

object AndroidTimeProvider : Time.TimeProvider {
	override fun getClockTime() = System.currentTimeMillis()
	override fun getElapsedTime() = SystemClock.elapsedRealtime()
}