package com.codility.recyclerview

import java.io.Serializable

/**
 * Created by Govind on 3/19/2018.
 */

class User(val name: String, val address: String) : Serializable {

    companion object {

        fun getUserList(): ArrayList<User> {
            val users = ArrayList<User>()
            users.clear()
            users.add(User("Govind ", "Siliguri"))
            users.add(User("Anish ", "Jamshedpur"))
            users.add(User("Rahul ", "Haryana"))
            users.add(User("Alphonse ", "Hubli"))
            users.add(User("Vasant ", "Karnataka"))
            users.add(User("Shivaraj ", "Bangalore"))
            users.add(User("Adnan ", "New delhi"))
            users.add(User("Victoria ", "Mangalore"))
            users.add(User("Divya ", "Ludhiana"))
            users.add(User("Dhaya ", "Tamil Nadu"))
            users.add(User("Archana ", "Devanahalli"))
            users.add(User("Junaid ", "Chikbalapur"))
            users.add(User("Jamal ", "Nepal"))
            users.add(User("Tejsvi ", "Uttar Pradesh"))

            return users
        }
    }
}