object WallService {

    fun add(addNote: AddNote, notes: MutableList<AddNote>): Int{
        val noteId = if (notes.isEmpty()) 1 else notes.size + 1;
        val addNote = addNote.copy(noteId = noteId)
        notes.add(addNote)
        return noteId
    }


    fun addCreateComment(createComment: CreateComment, notes: MutableList<AddNote>, createComments: MutableList<CreateComment>): Int {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == createComment.noteId){
                val commentId = if (createComments.isEmpty())1 else createComments.size + 1;
                val createComment = createComment.copy(commentId = commentId)
                createComments.add(createComment)
            }
        }
        return createComments.size
    }


    fun delete(noteId: Int, notes: MutableList<AddNote>): Int {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == noteId){
                notes.removeAt(index)
                return 1
            }
        }
        return 180
    }


    fun deleteComment(ownerId: Int, deleteComment: Int, notes: MutableList<AddNote>, createComments: MutableList<CreateComment>): Int{

        for (createComment in createComments) {
            if (createComment.ownerId == ownerId && createComment.commentId == deleteComment) {
                createComment.deleteLabel = 0
                return 1
            }
        }
        return 181
    }


    fun edit(addNote: AddNote, notes: MutableList<AddNote>): Int {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == addNote.noteId){
                notes[index] = addNote
                return 1
            }
        }
        return 180
    }


    fun editComment(commentId: Int, ownerId: Int, messageEdit: String,createComments: MutableList<CreateComment>): Int {
        for ((index, createComment) in createComments.withIndex()) {
            if (createComment.ownerId == ownerId && createComment.deleteLabel != 0 && createComment.commentId == commentId) {
                createComment.message = messageEdit
                return 1
            }
        }
        return 181
    }



    fun get(noteIds: List<Int>, notes: MutableList<AddNote>,listOfNotes:MutableList<AddNote>):List<Note> {
        for (noteId in noteIds) {
            val noteId = noteId
            for ((index, note) in notes.withIndex()) {
                if (note.noteId == noteId){
                    listOfNotes.add(notes[index])
                }
            }
        }
        return listOfNotes
    }

    fun getById(noteId: Int, notes: MutableList<AddNote> ) : AddNote?{
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == noteId){
                return note
            }
        }
        return null
    }

    fun getComments(noteId: Int, createComments: MutableList<CreateComment>, listOfComments: MutableList<CreateComment>): List<Note> {
        for ((index, createComment) in createComments.withIndex()){
            if (createComment.noteId == noteId && createComment.deleteLabel != 0){
                listOfComments.add(createComment)
            }
        }
        return listOfComments
    }

    fun restoreComment(restoreComment:Int, createComments: MutableList<CreateComment>): Int{
        for ((index, createComment) in createComments.withIndex()) {
            if (createComment.commentId == restoreComment){
                createComment.deleteLabel = 1
                return 1
            }
        }
        return 183
    }
}
