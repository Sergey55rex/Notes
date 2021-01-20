import org.junit.Test

import org.junit.Assert.*

class CommentServiceTest {
    val commentService = CommentService
    val noteService = NoteService
    val note = emptyList<Note>()
    var notes = note.toMutableList()
    val commenten = emptyList<Comment>()
    var comments = commenten.toMutableList<Comment>()
    val listOfNote = emptyList<Note>()
    // var listOfNotes =  listOfNote.toMutableList()
    val listOfComment = emptyList<Comment>()
    //var listOfComments =  listOfComment.toMutableList<Comment>()

    @Test
    fun add() {
        noteService.add(Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        ),notes,1)

        val expected = Comment(
                1,
                0,
                0,
                0,
                "message",
                "",
                1
        )
        val result = commentService.add(expected,notes,comments)
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
        ),notes,1)

        val expected = Comment(
                1,
                0,
                0,
                0,
                "message",
                "",
                1
        )

        val result = commentService.add(expected,notes,comments)
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
        ),notes,1)

        commentService.add(Comment(
                1,
                0,
                1,
                0,
                "message",
                "",
                1
        ),notes, comments)

        val expected = Comment(
                1,
                0,
                1,
                0,
                "message",
                "",
                1
        )
        val result = commentService.delete(expected,notes,comments)
        assertEquals(1, result)
    }

    @Test
    fun restore() {
        noteService.add(Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        ),notes,1)

        commentService.add(Comment(
                1,
                0,
                1,
                0,
                "message",
                "",
                0
        ),notes, comments)

        val expected = Comment(
                1,
                0,
                1,
                0,
                "message",
                "",
                1
        )
        val result = commentService.restore(expected,notes,comments)
        assertEquals(1, result)
    }

    @Test
    fun get() {
        noteService.add(Note(
                "title",
                "text",
                "all",
                "all",
                1,
                0
        ),notes,1)

        commentService.add(Comment(
                1,
                0,
                1,
                0,
                "message",
                "",
                0
        ),notes, comments)

        val expected = Comment(
                1,
                0,
                1,
                0,
                "message",
                "",
                1
        )

        val expecteds = listOf(expected)
        val result = commentService.get(expected,notes,comments)
        assertEquals(expecteds, result)
    }

}