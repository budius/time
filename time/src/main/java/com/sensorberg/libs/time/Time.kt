package com.sensorberg.libs.time

object Time {

	fun getEpochTime(): Long = provider.getClockTime()
	fun getElapsedTime(): Long = provider.getElapsedTime()

	fun elapsed(): ElapsedTime {
		return ElapsedTime(getElapsedTime())
	}

	interface TimeProvider {
		fun getClockTime(): Long
		fun getElapsedTime(): Long
	}

	private var provider: TimeProvider = AndroidTimeProvider

	fun setProvider(provider: TimeProvider?) {
		if (provider == null) {
			this.provider = AndroidTimeProvider
		} else {
			this.provider = provider
		}
	}
}

class ElapsedTime(private val startTime: Long) {
	private val _laps = mutableMapOf<String, Long>()
	val laps: Map<String, Long> get() = _laps

	fun elapsed() = Time.getElapsedTime() - startTime

	fun lap(tag: String): Long {
		val diff = elapsed()
		_laps[tag] = diff
		return diff
	}
}