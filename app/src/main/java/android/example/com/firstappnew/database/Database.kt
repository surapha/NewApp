package android.example.com.firstappnew.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase(){
    abstract val databaseDao: DatabaseDAO

    companion object{
        @Volatile
        private var INSTANCE: android.example.com.firstappnew.database.Database? = null
        fun getInstance(context: Context): android.example.com.firstappnew.database.Database {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        android.example.com.firstappnew.database.Database::class.java,
                        "database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}