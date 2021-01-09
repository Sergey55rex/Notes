
interface Note {
    val noteId: Int
        get() = 0
    val ownerId: Int
        get() = 0
    val title: String
        get() = " "
    val text: String
        get() = " "
    val privacyView: String
        get() = "all"
    val privacyComment: String
        get() = "all"

}

data class AddNote (
        override var noteId: Int,
        override var title: String = "",
        override var text: String ="",
        override var privacyView: String = "all",
        override var privacyComment: String = "all",
): Note{
}




fun add(notes: MutableList<AddNote>){
    val noteId = if (notes.isEmpty()) 1 else notes.size + 1;
    notes.add(0,element = AddNote(
            noteId = noteId,
            "TITLE",
            "TEXT",
            "all",
            "all"))
}

fun delete(notes: MutableList<AddNote>): Boolean {
    val deleteNoteId = 2
    for ((index, note) in notes.withIndex()) {
        if (note.noteId == deleteNoteId){
            notes.removeAt(index)
            return true
        }
    }
    return false
}




fun edit(notes: MutableList<AddNote>): Boolean {
    val noteId = 2
    for ((index, note) in notes.withIndex()) {
        if (note.noteId == noteId){
            note.title = "Title33"
            note.text = "Text 33"
            return true
        }
    }
    return false
}

fun editComment(createComments: MutableList<CreateComment>): Boolean {
    val commentId = 1
    for ((index, createComment) in createComments.withIndex()) {
        if (createComment.deleteLabel != 0){
            if (createComment.commentId == commentId){
                createComment.message = "message55"
                createComment.ownerId = 22
                return true
           }
        }
    }
    return false
}




