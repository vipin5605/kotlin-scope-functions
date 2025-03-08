package com.example.myapplication



fun main() {


    /**
     * Invoke letDemonstration with student object
     */
    letDemonstration(Student(1, "Sajan"))

    println("\n##################\n")

    /**
     * Invoke letDemonstration with student object
     */
    alsoDemonstration(Student(2, "Niza"))

    println("\n##################\n")


    /**
     * Invoke runDemonstration with student object
     * to find school name
     */
    returnDemonstration(Student(3, "Raza"))

    println("\n##################\n")

    /**
     * Invoke applyDemonstration to
     * assign a rollNo
     */
    applyDemonstration(Student(3, "Samaar"))

    println("\n##################\n")

    withDemonstration(Student(3, "Nandha"))

}

data class Student(var rollNo : Int, val name : String) {
    fun doSomething() {
        println("Student started learning")
    }
}

/**
 * let Returns Unit
 * let block executes when student object is not null
 */
fun letDemonstration(student: Student?) {
    student?.let {
        println("Student name is ${it.name}")
        it.doSomething()
    }
}

// #################################################


/**
 * also Returns object itself
 * you can execute object independent
 * operations in also block
 */
fun alsoDemonstration(student: Student?) {
    student?.also {
        // Additional actions
        println("Student ${it?.name} enrolled for Football camp")
    }?.doSomething()
}


// #################################################


/**
 * Run can return custom values
 * based on last line of block
 * you can run both on the object and
 * off the object operations
 */
fun returnDemonstration(student: Student?) {
    val result = student?.run {
        // Code to execute on the object
        doSomething()
        val prefix = "${student.name} belongs to "
        runAnotherFunction(prefix)
    }
    println(result)
}

fun runAnotherFunction(prefix : String) : String {
    val school = prefix.plus("SCG School")
    return school
}


// #################################################


/**
 * apply block can modify object properties
 * return value is object itself
 */
fun applyDemonstration(student: Student?) {
    student?.apply {
        println("Proposed roll number for student ${student.name} is ${student.rollNo}")
        rollNo = checkRollNoExist(rollNo)
        println("Assigned roll number for student ${student.name} is ${student.rollNo}")

    }
}

fun checkRollNoExist(studentId : Int) : Int {
    val ids = listOf(1,2,3)
    return if (ids.contains(studentId)) {
        ids.max().inc()
    } else {
        studentId
    }
}

// #################################################

/**
 * Not an extend function
 * Return value is custom based on last line
 */
fun withDemonstration(student: Student?) {
    val rollNo = with(student) {
        println("Proposed roll number for student ${student?.name} is ${student?.rollNo}")
        checkRollNoExist(this!!.rollNo)
        }
    println("Assigned roll number for student ${student?.name} is $rollNo")

}
