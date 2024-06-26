package dev.toastbits.ytmkt.uistrings.localised

data class HMSData(val hours: String, val minutes: String, val seconds: String, val splitter: String = "")

fun getHoursMinutesSecondsSuffixes(hl: String?): HMSData? {
    when (hl?.lowercase()) {
        "zh-cn" -> return HMSData("时间", "分", "秒")
        "zh-tw" -> return HMSData("時間", "分", "秒")
    }

    return when (hl?.split('-', limit = 2)?.firstOrNull()) {
        "en", null -> HMSData("hours", "minutes", "seconds", " ")
        "ja" -> HMSData("時間", "分", "秒")
        "zh" -> HMSData("时间", "分", "秒")
        "fr" -> HMSData("heures", "minutes", "secondes", " ")
        "tr" -> HMSData("saat", "dakika", "saniye", " ")
        "ru" -> HMSData("часы", "минуты", "секунды", " ")
        else -> null
    }
}
