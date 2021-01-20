fun main(){
    val note = emptyList<Note>()
    var notes = note.toMutableList()

    var comment = emptyList<Comment>()
    var comments = comment.toMutableList<Comment>()

    NoteService.add(Note(
            "title",
            "text",
            "all",
            "all",
            1,
            0
    ),notes, 1)

    println(NoteService.add(Note(
            "title",
            "text",
            "all",
            "all",
            1,
            0
    ),notes, 1))

    println(notes)

    println(CommentService.add(Comment(
            1,
            0,
            0,
            0,
            "message",
            "",
            1
    ), notes, comments))
    println(comments)


    NoteService.delete(Note(
            "title",
            "text",
            "all",
            "all",
            1,
            0
    ),notes,1)


    CommentService.delete(Comment(
            1,
            0,
            1,
            0,
            "message",
            "",
            1), notes, comments)
    println(comments)

    NoteService.edit(Note(
            "title22",
            "text22",
            "all",
            "all",
            1,
            0
    ),notes,1)
    println(notes)

    println(CommentService.edit(Comment(
            1,
            0,
            1,
            0,
            "message44",
            "",
            1), notes, comments))
    println(comments)

    CommentService.restore(Comment(
            1,
            0,
            1,
            0,
            "message",
            "",
            0), notes, comments)
    println(comments)


    println(NoteService.get(Note(
            "title",
            "text",
            "all",
            "all",
            1,
            0
    ),notes,1))


    println(NoteService.getById(Note(
            "title",
            "text",
            "all",
            "all",
            1,
            0
    ),notes,2))

    println(CommentService.get(Comment(
            1,
            0,
            1,
            0,
            "message",
            "",
            1), notes, comments))
}

