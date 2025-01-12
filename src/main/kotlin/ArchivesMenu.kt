data class Archive(val name: String, val notes: MutableList<Note> = mutableListOf()) {
    override fun toString(): String {
        return name
    }
}

class ArchivesMenu {

    private val archives = mutableListOf<Archive>()

    fun createArchive() {
        val name = Menu().readInput { print("Введите название архива: ") }
        archives.add(Archive(name))
        println()
        println("Архив '$name' успешно создан.")

    }

    fun viewArchives() {
        Menu().selectMenu("АРХИВЫ:", archives, {createArchive()}) { archive ->
            NotesMenu().viewNotes(archive)
        }
    }

}
