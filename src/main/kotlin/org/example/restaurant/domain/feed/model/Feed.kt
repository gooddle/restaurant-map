package org.example.restaurant.domain.feed.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.example.restaurant.domain.user.model.User
import java.time.LocalDateTime

@Entity
class Feed(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
    var user : User,

    @Column(name ="title",nullable = false)
    var title: String,

    @Column(name = "content",nullable = false)
    var content: String,

    @Column(name ="created_at",nullable=false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name ="updated_at")
    var updatedAt: LocalDateTime?= null,

    @Column(name ="deleted_at")
    var deletedAt: LocalDateTime? = null,
)