package com.swszz.openfga.infrastructure.mysql

import jakarta.persistence.*

@Entity
@Table
class Student(
    @Column
    val name: String,
    @Column
    val email: String,
    @Column
    val phone: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0L
}