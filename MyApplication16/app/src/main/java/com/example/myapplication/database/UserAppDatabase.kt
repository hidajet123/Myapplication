package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserDataBase::class], version = 1, exportSchema = false)
abstract class UserAppDatabase : RoomDatabase() {
     abstract val userDao: UserDao

    companion object {

        @Volatile
        private var INSTANCE: UserAppDatabase? = null

        fun getInstance(context: Context): UserAppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserAppDatabase::class.java,
                        "user_database"
                    ) .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}