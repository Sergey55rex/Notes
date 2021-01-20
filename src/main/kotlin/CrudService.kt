interface CrudService<N, S, C> {
    fun add(variable1: N, variable2: S, variable3: C): Int
    fun delete(variable1: N, variable2: S, variable3: C): Int
    fun edit(variable1: N, variable2: S, variable3: C): Int
    fun restore(variable1: N, variable2: S, variable3: C): Int
    fun get(variable1: N, variable2: S, variable3: C): List<N>
    fun getById(variable1: N, variable2: S, variable3: C): Note?
}
