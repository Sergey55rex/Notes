
import org.junit.Test

import org.junit.Assert.*
import kotlin.math.absoluteValue

class WallServiceTest {
    val service = WallService
    val note = emptyList<AddNote>()
    var notes = note.toMutableList()
    val createCommenten = emptyList<CreateComment>()
    var createComments = createCommenten.toMutableList<CreateComment>()
    val listOfNote = emptyList<AddNote>()
    var listOfNotes =  listOfNote.toMutableList()
    val listOfComment = emptyList<CreateComment>()
    var listOfComments =  listOfComment.toMutableList<CreateComment>()
    @Test
    fun add() {
        val expected = AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        )
        val result = service.add(expected,notes)
        assertEquals(1, result)

    }

    @Test
    fun addCreateComment() {
        service.add(AddNote(
                0,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        val expected = CreateComment(
                1,
                1,
                1,
                0,
                "message2",
                ""
        )
        val result = service.addCreateComment(expected,notes,createComments)
        assertEquals(1, result)
    }

    @Test
    fun delete() {
        service.add(AddNote(
                0,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        val expected = 1
        val result = service.delete(expected, notes)
        assertEquals(1
                , result)
    }

    @Test
    fun deleteComment() {
        service.add(AddNote(
                0,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        service.addCreateComment(CreateComment(
                1,
                1,
                1,
                0,
                "message2",
                ""),notes,createComments)
        val expected = 1
        val expected2 = 1
        val result = service.deleteComment(expected, expected2,notes,createComments)
        assertEquals( 1, result)
    }

    @Test
    fun edit() {
        service.add(AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        val expectede = AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        )

        val result = service.edit(expectede, notes)
        assertEquals(1,result)
    }

    @Test
    fun editComment() {
        service.add(AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        service.addCreateComment(CreateComment(
                1,
                1,
                1,
                0,
                "message2",
                ""),notes,createComments)

        val result = service.editComment(1,1, "messageEdit", createComments)
        assertEquals(1,result)

    }

    @Test
    fun get() {
        service.add(AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        service.add(AddNote(
                1,
                "TITLE1",
                "TEXT1",
                "all",
                "all"
        ),notes)
        val expected = notes
        listOfNotes
        val result = service.get(listOf(1,2),notes, listOfNotes)
        assertEquals(expected,result)
    }

    @Test
    fun getById() {
        service.add(AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        val expected = AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        )
        val result = service.getById(1, notes)
        assertEquals(expected,result)
    }

    @Test
    fun getComments() {
        service.add(AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        service.addCreateComment(CreateComment(
                1,
                1,
                1,
                0,
                "message2",
                ""),notes,createComments)
        service.addCreateComment(CreateComment(
                1,
                1,
                2,
                0,
                "message2",
                ""),notes,createComments)
        createComments
        val expected = listOfComments
        val result = service.getComments(1, createComments, listOfComments)
        assertEquals(expected,result)
    }

    @Test
    fun restoreComment() {
        service.add(AddNote(
                1,
                "TITLE",
                "TEXT",
                "all",
                "all"
        ),notes)
        val expected = service.addCreateComment(CreateComment(
                1,
                1,
                1,
                0,
                "message2",
                ""),notes,createComments)
        val result = service.restoreComment(1, createComments)
        assertEquals(expected,result)
    }
}

