object NoteService: CrudService<Note, MutableList<Note>, Int> {

    override fun add(note: Note, notes: MutableList<Note>, noteId: Int): Int {
        val noteId = if (notes.isEmpty()) 1 else notes.size + 1;
        val note = note.copy(noteId = noteId)
        notes.add(note)
        return 1
    }

    override fun delete(note: Note, notes: MutableList<Note>, noteId: Int): Int {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == noteId){
                notes.removeAt(index)
                return 1
            }
        }
        return 180
    }

    override fun edit(note: Note, notes: MutableList<Note>, noteId: Int): Int {
        val editNote = note
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == note.noteId){
                notes[index] =editNote
                return 1
            }
        }
        return 180
    }

    override fun restore(variable1: Note, variable2: MutableList<Note>, variable3: Int): Int {
        TODO("Not yet implemented")
    }

    override fun get(note: Note, notes: MutableList<Note>, noteId: Int):List<Note> {
        val ower = note.ownerId
        var listOfNotes = mutableListOf<Note>()
        for ((index, note) in notes.withIndex()) {
            if (note.ownerId == ower){
                listOfNotes.add(note)
            }
        }
        return listOfNotes
    }

    override fun getById(note: Note, notes: MutableList<Note>, noteId: Int) : Note?{

        for ((index, note) in notes.withIndex()) {
            if (note.noteId == noteId){
                return note
            }
        }
        return null
    }

}
