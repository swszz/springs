package com.swszz.springs.jpainheritance

import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class Component(
    private val failedStudentRepository: FailedStudentRepository,
    private val passedStudentRepository: PassedStudentRepository,
    private val noneStudentRepository: NoneStudentRepository,
) {
    @EventListener(ApplicationStartedEvent::class)
    fun saveStudents() {
        failedStudentRepository.save(FailedStudent())
        passedStudentRepository.save(PassedStudent())
        noneStudentRepository.save(NoneStudent())
    }
}