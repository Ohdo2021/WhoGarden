package com.ohdo.whogarden.chatting

import java.security.acl.Owner

data class MessageModel(
    val owner: Owner,
    val nickname: String,
    val content: String
) {
    var collapseName: Boolean = false

    enum class Owner(val viewType: Int) {
        SENDER(0),
        RECEIVER(1);
    }
}