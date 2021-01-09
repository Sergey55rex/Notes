data class CreateComment  (
        override val noteId: Int,
        override var ownerId: Int,
        val commentId: Int = 0,
        val replyTo: Int,
        var message: String,
        val guid: String,
        var deleteLabel: Int = 1,
): Note

fun addCreateComment(createComments: MutableList<CreateComment>) {
    val commentId = if (createComments.isEmpty())1 else createComments.size + 1;
    createComments.add(0,element = CreateComment(
            1,
            33,
            commentId = commentId,
            55,
            "message2",
            ""
    ))
}

fun deleteComment(createComments: MutableList<CreateComment>): Boolean{
    val deleteComment = 1
    for ((index, createComment) in createComments.withIndex()) {
        if (createComment.commentId == deleteComment){
            createComment.deleteLabel = 0
            return true
        }
    }
    return false
}

fun getComments(createComments: MutableList<CreateComment>): MutableList<Int> {
    val noteId = 1
    val createComment: List<Int> = emptyList<Int>()
    var createCommentes = createComment.toMutableList()
    for ((index, createComment) in createComments.withIndex()){
        if (createComment.noteId == noteId){
            if (createComment.deleteLabel != 0){
            createCommentes.add(createComment.commentId)
            }
        }
    }
    return createCommentes
}

fun restoreComment(createComments: MutableList<CreateComment>): Boolean{
    val restoreComment = 1
    for ((index, createComment) in createComments.withIndex()) {
        if (createComment.commentId == restoreComment){
            createComment.deleteLabel = 1
            println(createComments)
            return true
        }
    }
    return false
}

