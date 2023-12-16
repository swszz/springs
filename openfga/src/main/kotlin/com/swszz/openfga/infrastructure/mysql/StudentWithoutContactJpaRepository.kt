package com.swszz.openfga.infrastructure.mysql

import org.springframework.data.jpa.repository.JpaRepository

interface StudentWithoutContactJpaRepository : JpaRepository<StudentWithoutContact, Long>