fun main(){
    val note = emptyList<AddNote>()
    var notes = note.toMutableList()

    val createCommenten = emptyList<CreateComment>()
    var createComments = createCommenten.toMutableList<CreateComment>()

    val listOfNote = emptyList<AddNote>()
    var listOfNotes =  listOfNote.toMutableList()

    val listOfComment = emptyList<CreateComment>()
    var listOfComments =  listOfComment.toMutableList<CreateComment>()

    println(WallService.add(AddNote(
            0,
            "TITLE",
            "TEXT",
            "all",
            "all"),notes))

    println(WallService.add(AddNote(
            0,
            "TITLE1",
            "TEXT2",
            "all",
            "all"),notes))

    println(WallService.add(AddNote(
            0,
            "TITLE3",
            "TEXT3",
            "all",
            "all"),notes))

    println(WallService.addCreateComment(CreateComment(
            1,
            1,
            1,
            0,
            "message2",
            ""

    ) ,notes, createComments))

    println(WallService.addCreateComment(CreateComment(
            1,
            1,
            0,
            0,
            "message2",
            ""

    ) ,notes, createComments))

    println(WallService.delete(1,notes))

    println(WallService.deleteComment(1, 2, notes, createComments))


    println(WallService.edit(AddNote(
            2,
            "Title edit",
            "text edit",
            "all",
            "all"
    ), notes))

    println(WallService.edit(AddNote(
            1,
            "Title edit",
            "text edit",
            "all",
            "all"
    ), notes))



    println(WallService.editComment(1,1, "message edit" ,createComments))

    println(WallService.get(listOf(2, 3), notes, listOfNotes))

    println(WallService.getById(2, notes))

    println( WallService.restoreComment(2, createComments))

    println(WallService.getComments(1, createComments, listOfComments))



}
