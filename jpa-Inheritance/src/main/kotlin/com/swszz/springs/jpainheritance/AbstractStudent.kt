package com.swszz.springs.jpainheritance

import jakarta.persistence.*

@Entity(name = "Student")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "exam_status",
    discriminatorType = DiscriminatorType.STRING
)
@Table(indexes = [Index(name = "idx_exam_status", columnList = "exam_status")])
abstract class AbstractStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
}