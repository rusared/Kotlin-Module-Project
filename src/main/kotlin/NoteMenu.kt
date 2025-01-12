import java.util.Scanner

class NoteMenu {

    fun viewNote(note: Note) {
        println()
        println("-----------\n  ${note.name}\n-----------\n${note.text}\n-----------")
        println()
        println("Нажмите Enter, чтобы выйти из заметки")
        Scanner(System.`in`).nextLine()
        return
    }

}
