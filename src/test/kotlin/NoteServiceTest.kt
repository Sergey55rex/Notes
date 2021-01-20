import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    val noteService = NoteService
    val note = emptyList<Note>()
    var notes = note.toMutableList()
    val createCommenten = emptyList<Comment>()
    // var createComments = createCommenten.toMutableList<Comment>()
    val listOfNote = emptyList<Note>()
    // var listOfNotes =  listOfNote.toMutableList()
    val listOfComment = emptyList<Comment>()
    // var listOfComments =  listOfComment.toMutableList<Comment>()

    @Test
    fun add() {
        val expected =  Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        )
        val result = noteService.add(expected,notes,1)
        assertEquals(1, result)

    }

    @Test
    fun delete() {
        noteService.add(Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        ),notes, 1)
        val expected = Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        )
        val result = noteService.delete(expected, notes,1)
        assertEquals(1, result)
    }

    @Test
    fun edit() {
        noteService.add(Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        ),notes, 1)
        val expected = Note(
                "title1",
                "text1",
                "all",
                "all",
                1,
                0
        )
        val result = noteService.edit(expected,notes,1)
        assertEquals(1, result)

    }

//    @Test
//    fun restore() {
//    }

    @Test
    fun get() {
        noteService.add(Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        ),notes, 1)
        val expected = Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        )
        val expecteds = listOf(expected)
        val result = noteService.get(expected,notes,1)
        assertEquals(expecteds, result)
    }

    @Test
    fun getById() {
        noteService.add(Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        ),notes, 1)
        val expected = Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        )
        val result = noteService.getById(expected,notes,1)
        assertEquals(expected, result)
    }
}
