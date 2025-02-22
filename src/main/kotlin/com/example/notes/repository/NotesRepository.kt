package com.example.notes.repository

import com.example.notes.model.NotesEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NotesRepository :JpaRepository<NotesEntity,Long>