package com.example.notes.services

import com.example.notes.model.NotesEntity
import com.example.notes.repository.NotesRepository
import org.springframework.stereotype.Service

@Service
class NotesServices (private val notesRepository: NotesRepository){


    fun getAll():List<NotesEntity> =notesRepository.findAll()

    fun addNote(notesEntity: NotesEntity):NotesEntity=notesRepository.save(notesEntity)

    fun delete(id:Long)=notesRepository.deleteById(id)

    fun update(id: Long,notesEntity: NotesEntity):NotesEntity{
        val existingNote=notesRepository.findById(id).orElseThrow { Exception("Note not found") }
        existingNote.title=notesEntity.title
        existingNote.content=notesEntity.content
        return notesRepository.save(existingNote)
    }

    fun getById(id: Long): NotesEntity {
        return notesRepository.findById(id).orElseThrow { NoSuchElementException("Note not found") }
    }

}