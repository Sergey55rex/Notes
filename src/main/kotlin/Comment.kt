data class Comment(
        val noteId: Int,
        var ownerId: Int,
        val commentId: Int,
        val replyTo: Int,
        var message: String,
        val guid: String,
        var deleteLabel: Int = 1,
)
