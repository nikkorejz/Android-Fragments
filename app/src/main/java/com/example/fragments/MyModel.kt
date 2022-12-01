package com.example.fragments

data class MyModel(val name: String, val description: String) {
    companion object {
        val models = arrayOf(
            MyModel("Joe", "42 age"),
            MyModel("Kate", "28 age"),
            MyModel("Peter", "34 age"),
        )
    }
}