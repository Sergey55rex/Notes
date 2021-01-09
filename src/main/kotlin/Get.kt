data class Get(
        val noteIds: List<Int>?,
        //val noteIds: Int,
        val userId: Int,
        val offset: Int = 0,
        val count: Int = 20,
        val sort: Int = 0,
): Note


fun get(notes: MutableList<AddNote>): MutableList<Int> {
    val noteId: List<Int> = emptyList<Int>()
    var noteIds = noteId.toMutableList()
    for (note in notes){
        noteIds.add(note.noteId)
    }
    return noteIds
}


fun getById(notes: MutableList<AddNote>)  {
    val noteId = 1
    for (note in notes){
        if (note.noteId == noteId){
        }
    }
}

