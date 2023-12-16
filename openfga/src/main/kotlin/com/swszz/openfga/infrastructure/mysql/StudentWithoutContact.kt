package com.swszz.openfga.infrastructure.mysql

import jakarta.persistence.*

@Entity
@Table(name = "Student")
class StudentWithoutContact(
    @Column()
    val name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0L
}