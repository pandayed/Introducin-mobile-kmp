package `in`.introduc.mobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform