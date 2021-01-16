data class Get(
        val noteIds: List<Int>?,
        //val noteIds: Int,
        val userId: Int,
        val offset: Int = 0,
        val count: Int = 20,
        val sort: Int = 0,
): Note


