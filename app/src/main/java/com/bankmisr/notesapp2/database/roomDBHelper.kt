package com.bankmisr.notesapp2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class RoomDBHelper:RoomDatabase(){

    abstract val dao:NoteDao

    companion object{

        private var INSTANCE:RoomDBHelper?=null
        fun getInstance(c: Context):RoomDBHelper{
            return INSTANCE?: synchronized(this){
                var instance = Room.databaseBuilder(c,RoomDBHelper::class.java,"MyDB")
                    .build()
                INSTANCE=instance
                instance
            }
        }
    }

}