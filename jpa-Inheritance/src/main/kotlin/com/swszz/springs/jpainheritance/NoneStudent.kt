package com.swszz.springs.jpainheritance

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("NONE")
class NoneStudent : AbstractStudent()