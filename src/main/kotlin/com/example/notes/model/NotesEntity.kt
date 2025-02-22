package com.example.notes.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
@Table(name = "notesList")
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
data class NotesEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long=0,
    var title:String,
    var content: String
)