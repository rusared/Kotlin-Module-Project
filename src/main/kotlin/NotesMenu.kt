data class Note(var name: String, var text: String) {
    override fun toString(): String {
        return name
    }
}

class NotesMenu {

    private val notes = mutableListOf<Note>()

    private fun createNote(archive: Archive) {
        val name = Menu().readInput { print("Введите название заметки: ") }
        val text = Menu().readInput { print("Введите текст заметки: ") }
        archive.notes.add(Note(name, text))
        println()
        println("Заметка '$name' успешно добавлена.")
    }

    fun viewNotes(archive: Archive) {
        Menu().selectMenu("ЗАМЕТКИ архива '${archive.name}':", archive.notes, { createNote(archive) }) { note ->
            NoteMenu().viewNote(note)
        }
    }

}
