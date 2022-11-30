package com.zzq.jetpackuse.utils

import android.util.Log
import org.junit.Assert
import org.junit.Test

internal class AndroidInfoUtilTest {
    private val tag = "AndroidTestTag"

    @Test
    fun getSystemVersion() {
        val systemVersion = AndroidInfoUtil.getSystemVersion()
        Log.e(tag, "systemVersion: " + (systemVersion ?: ""))
        Assert.assertNotEquals("", systemVersion)
        Assert.assertNotEquals(null, systemVersion)
    }

    @Test
    fun getSystemModel() {
        val systemModel = AndroidInfoUtil.getSystemModel()
        Log.e(tag, "systemModel: " + (systemModel ?: ""))
        Assert.assertNotEquals("", systemModel)
        Assert.assertNotEquals(null, systemModel)
    }

    @Test
    fun getDeviceManufacturer() {
        val deviceManufacturer = AndroidInfoUtil.getDeviceManufacturer()
        Log.e(tag, "deviceManufacturer: " + (deviceManufacturer ?: ""))
        Assert.assertNotEquals("", deviceManufacturer)
        Assert.assertNotEquals(null, deviceManufacturer)
    }

    @Test
    fun getDeviceBrand() {
        val deviceBrand = AndroidInfoUtil.getDeviceBrand()
        Log.e(tag, "deviceBrand: " + (deviceBrand ?: ""))
        Assert.assertNotEquals("", deviceBrand)
        Assert.assertNotEquals(null, deviceBrand)
    }
}