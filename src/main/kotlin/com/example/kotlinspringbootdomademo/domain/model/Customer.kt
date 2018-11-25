package com.example.kotlinspringbootdomademo.domain.model

data class Customer(val id: Int? = null, val name: String, val email: String, val phone_number: String, val github_name: String, val twitter_name: String, val main_org: String, val sub_org: String)
