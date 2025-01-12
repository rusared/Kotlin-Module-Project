import java.util.Scanner

class Menu {

    fun <T> printMenu(type: String, list: List<T>) {
        println()
        println(type)
        println("1. Создать")
        list.forEachIndexed { index, element ->
            println("${index + 2}. ${element}")
        }
        println("0. Выход")
        print("Введите цифру из списка выше: ")
    }

    fun readInput(printItem: () -> Unit): String {
        while (true) {
            printItem()
            val inputText = Scanner(System.`in`).nextLine()
            if (inputText.trim(' ').isEmpty()) {
                println()
                println("Ввод не может быть пустым!")
                continue
            }
            return inputText
        }
    }

    fun <T> selectMenu(itemsType: String, items: List<T>, createItem: () -> Unit, viewItem: (T) -> Unit) {
        while (true) {
            val choice = readInput { printMenu(itemsType, items) }
            when (choice) {
                "1" -> createItem()
                "0" -> return
                else -> {
                    val index = choice.toIntOrNull()
                    if (index == null) {
                        println()
                        println("Некорректный ввод!")
                        println("Необходимо ввести цифру.")
                    } else if (index-2 in items.indices) {
                        viewItem(items[index-2])
                    } else {
                        println()
                        println("Такой цифры нет.")
                        println("Пожалуйста, введите цифру из представленного списка.")
                    }
                }
            }
        }
    }
}
