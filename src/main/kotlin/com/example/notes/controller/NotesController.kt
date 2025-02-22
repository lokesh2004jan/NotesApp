package com.example.notes.controller

import com.example.notes.model.NotesEntity
import com.example.notes.services.NotesServices
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/notes")
class NotesController(private val notesServices: NotesServices) {

    @GetMapping()
    fun getAllNotes():List<NotesEntity> = notesServices.getAll()

    @PostMapping("/add")
    fun addNote(@RequestBody notesEntity: NotesEntity):NotesEntity= notesServices.addNote(notesEntity)

    @PutMapping("/update/{id}")
    fun updateNote(@PathVariable id:Long,@RequestBody notesEntity: NotesEntity):String{
        notesServices.update(id,notesEntity)
        return "updated !!"
    }

    @GetMapping("/search/{id}")
    fun search(@PathVariable id: Long): ResponseEntity<NotesEntity> {
        return try {
            ResponseEntity.ok(notesServices.getById(id))
        } catch (e: NoSuchElementException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }


    @DeleteMapping("/delete/{id}")
    fun remove(@PathVariable id: Long):String{
        notesServices.delete(id)
        return "note deleted !!"
    }
}