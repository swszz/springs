package com.swszz.openfga

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val openFgaService: OpenFgaService
) {


    @GetMapping("1")
    fun save() {
        openFgaService.save()
    }

    @GetMapping("2")
    fun saveAndFlush() {
        openFgaService.saveAndFlush()
    }

    @GetMapping("3")
    fun saveAndDoFlush() {
        openFgaService.saveAndDoFlush()
    }

    @GetMapping("4")
    fun saveAndDoFlushBeforeThrow() {
        openFgaService.saveAndDoFlushBeforeThrow()
    }

    @GetMapping("5")
    fun saveAndDoFlushAfterThrow() {
        openFgaService.saveAndDoFlushAfterThrow()
    }

}