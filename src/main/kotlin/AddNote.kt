data class AddNote (
        override var noteId: Int,
        override var title: String = "",
        override var text: String ="",
        override var privacyView: String = "all",
        override var privacyComment: String = "all",
): Note
