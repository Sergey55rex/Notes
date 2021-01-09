
fun main(){
    val addNote = AddNote(
            0,
            "title11",
            "text22",
    )
    val createComment = CreateComment(
            1,
            0,
            0,
            4,
            "message1",
            "guid",
    )

    val note = emptyList<AddNote>()
    var notes = note.toMutableList()

    val createCommenten = emptyList<CreateComment>()
    var createComments = createCommenten.toMutableList<CreateComment>()

    add(notes)

    delete(notes)

    addCreateComment(createComments)
    addCreateComment(createComments)
    addCreateComment(createComments)

   deleteComment(createComments)

    edit(notes)

    editComment(createComments)
    println(createComments)

    val get = Get(
            get(notes),
            1,
            2,
            3,
            4
    )
    //println(get)

    getById(notes)

    println(getComments(createComments))

    //println(restoreComment(createComments))
}






