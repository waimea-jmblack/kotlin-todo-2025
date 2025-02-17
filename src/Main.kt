fun main() {
    val tasks = mutableListOf<Task>()

    // Make up some fake tasks for testing

    tasks.add(Task("Feed the cat", 3))
    tasks.add(Task("Kick the dog", 5))
    tasks.add(Task("Lick the fish", 2))

    tasks[2].markAsDone()

    println("======================")
    println(" To Do, You Big Loser")
    println("======================")
    println()

    while(true) {
        showTasks(tasks)
        when(getUserAction()) {
            'x' -> break
            'n' -> tasks.add(getNewTask())
            'd' -> println("DONE")
        }
    }
}

fun getUserAction(): Char {
    while (true) {
        // Show the menu
        println("[N]ew task")
        println("Toggle [d]one")
        println("E[x]it")
        print("> ")

        // Get input
        val action = readln().lowercase()

        // Did they type something?
        if (action.isNotEmpty()) {
            return action.first()
        }
    }

}


/**
 * Get a specific task from the task list
 * returning their selected task as done
 */

fun getTask(tasks: MutableList<Task>): Task {
    //Show the tasks, numbered
    var num = 1
    for(task in tasks) {
        print("$num: ")
        print(" ${task.priority} ")
        println(task.name)
        num++
    }
    //get the number of tasks from user
    print("Pick a task")
    val taskNum = readln().toInt()
    //return the selected task object
}

fun getNewTask(): Task {
    println("New task")

    print("Task name: ")
    val name = readln()

    print("Priority: ")
    val priority = readln().toInt()

    return Task(name, priority)
}



fun showTasks(tasks: MutableList<Task>) {
    for(task in tasks) {
        print(if(task.done) "[X]" else "[ ]")
        print(" ${task.priority} ")
        println(task.name)
    }
}


/**
 * Task class - holds info about a single task
 */
class Task(var name: String, var priority: Int) {
    var done: Boolean = false

    fun markAsDone() {
        done = true
    }

    fun markAsNotDone() {
        done = false
    }
}