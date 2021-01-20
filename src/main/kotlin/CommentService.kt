object CommentService: CrudService <Comment, MutableList<Note>, MutableList<Comment>> {
    override fun add(comment: Comment, notes: MutableList<Note>, comments: MutableList<Comment>) : Int {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == comment.noteId){
                val commentId = if (comments.isEmpty())1 else comments.size + 1;
                val comment = comment.copy(commentId = commentId)
                comments.add(comment)
            }
        }
        return comments.size
    }

    override fun delete(comment: Comment, notes: MutableList<Note>, comments: MutableList<Comment>): Int{
        val commenten = comment.ownerId
        val deleteComment = comment.commentId
        for (comment in comments) {
            if (deleteComment == comment.commentId && commenten == comment.ownerId) {
                comment.deleteLabel = 0
                return 1
            }
        }
        return 181
    }

    override fun edit(comment: Comment, notes: MutableList<Note>, comments: MutableList<Comment>): Int {
        val editComment = comment
        val ownerComment  = comment.ownerId
        val commentComment = comment.commentId
        for ((index, comment) in comments.withIndex()) {
            if (comment.ownerId == ownerComment && comment.deleteLabel != 0 && comment.commentId == commentComment) {
                comments[index] = editComment
                return 1
            }
        }
        return 181
    }

    override fun restore(comment: Comment, notes: MutableList<Note>, comments: MutableList<Comment>): Int {
        val commenten = comment.ownerId
        val deleteComment = comment.commentId
        for (comment in comments) {
            if (deleteComment == comment.commentId && commenten == comment.ownerId) {
                comment.deleteLabel = 1
                return 1
            }
        }
        return 181
    }

    override fun get(comment: Comment, notes: MutableList<Note>, comments: MutableList<Comment>): List<Comment> {
        val id = comment.noteId
        var listOfComments = mutableListOf<Comment>()
        for ((index, createComment) in comments.withIndex()){
            if (comment.noteId == id && comment.deleteLabel != 0){
                listOfComments.add(comment)
            }
        }
        return listOfComments
    }

    override fun getById(variable1: Comment, variable2: MutableList<Note>, variable3: MutableList<Comment>): Note? {
        TODO("Not yet implemented")
    }
}
