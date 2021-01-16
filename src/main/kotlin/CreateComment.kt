data class CreateComment  (
        override val noteId: Int,
        var ownerId: Int,
        val commentId: Int = 0,
        val replyTo: Int,
        var message: String,
        val guid: String,
        var deleteLabel: Int = 1,
): Note

