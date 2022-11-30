package com.zzq.jetpackuse.utils

import android.os.Build

object AndroidInfoUtil {

    /**
     * 获取当前手机系统版本号
     *
     * @return  系统版本号
     */
    fun getSystemVersion(): String? {
        return Build.VERSION.RELEASE
    }

    /**
     * 获取手机型号
     *
     * @return  手机型号
     */
    fun getSystemModel(): String? {
        return Build.MODEL
    }

    /**
     * 获取手机制造商
     *
     * @return  手机制造商
     */
    fun getDeviceManufacturer(): String? {
        var mtype: String? = ""
        try {
            mtype = Build.MANUFACTURER
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return mtype
    }

    /**
     * 获取手机厂商
     *
     * @return  手机厂商
     */
    fun getDeviceBrand(): String? {
        return Build.BRAND
    }
}