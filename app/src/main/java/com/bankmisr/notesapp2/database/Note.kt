package com.bankmisr.notesapp2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("note")
class Note (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("_id")
    val id:Int=0 ,
    @ColumnInfo("note_details")
    val noteDetails :String,
    @ColumnInfo("Note_Title")
    val noteTitle:String
)