package com.kmpstudy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform