package com.swszz.springs.oauth2.infrastructure.entity

import com.swszz.springs.oauth2.OAuth2Platforms
import jakarta.persistence.*

@Entity
@Table(
    name = "OAuth2Identification",
    indexes =
    [Index(name = "uidx_identification_platform", columnList = "identification, platform", unique = true)]
)
class OAuth2IdentificationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(columnDefinition = "VARCHAR (255)")
    val identification: String,

    @Column
    @Enumerated(EnumType.STRING)
    val platform: OAuth2Platforms
) : AbstractEntity()