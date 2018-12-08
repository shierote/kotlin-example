package com.example.kotlinspringbootdomademo.application.input

import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.Size

class CustomerInput {
    @NotBlank
    @Size(max = 20)
    var name: String? = null

    @NotBlank
    @Size(max = 50)
    var email: String? = null

    @NotBlank
    @Size(max = 50)
    var github_name: String? = null

    @NotBlank
    @Size(max = 50)
    var twitter_name: String? = null

    @NotBlank
    @Size(max = 50)
    var phone_number: String? = null

    @NotBlank
    @Size(max = 50)
    var main_org: String? = null

    @NotBlank
    @Size(max = 50)
    var sub_org: String? = null
}
