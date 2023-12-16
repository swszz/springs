package com.swszz.openfga.infrastructure.mysql

import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.fakerConfig
import java.util.*

class StudentGenerator {

    private val faker: Faker

    init {
        this.faker = Faker(config = fakerConfig { random = Random() })
    }

    fun random(): Student {
        val name: String = faker.name.name().replace(" ", "")
        return Student(
            name = name,
            email = faker.internet.safeEmail(name = name),
            phone = faker.phoneNumber.cellPhone.number()
        )
    }
}