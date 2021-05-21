package io.moonbucks.api.entity.member

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "members")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
abstract class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) open val id: Long?,
    open val uuid: String,
    open val password: String,
    open var displayName: String?,
    open var email: String?,
    open var state: String,
    open var activated: Boolean,
    @CreatedDate open val createdAt: Date,
    @LastModifiedDate open var updatedAt: Date,
) {
    abstract fun type(): String
}

@Entity
@DiscriminatorValue(value = "Members::Individual")
class IndividualMember(
    override val id: Long?,
    override val uuid: String,
    override val password: String,
    override var displayName: String?,
    override var email: String?,
    override var state: String,
    override var activated: Boolean,
    override val createdAt: Date,
    override var updatedAt: Date,
) : Member(
    id,
    uuid,
    password,
    displayName,
    email,
    state,
    activated,
    createdAt,
    updatedAt
) {
    override fun type(): String {
        return "individual"
    }
}

@Entity
@DiscriminatorValue(value = "Members::Administrator")
class Administrator(
    override val id: Long?,
    override val uuid: String,
    override val password: String,
    override var displayName: String?,
    override var email: String?,
    override var state: String,
    override var activated: Boolean,
    override val createdAt: Date,
    override var updatedAt: Date,
) : Member(
    id,
    uuid,
    password,
    displayName,
    email,
    state,
    activated,
    createdAt,
    updatedAt
) {
    override fun type(): String {
        return "administrator"
    }
}