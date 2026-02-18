package com.nexo.personal.nexo_personal

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform