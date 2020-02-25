package com.mz.spendingmanager.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mz.spendingmanager.model.dao.ExpenseDao
import com.mz.spendingmanager.model.entity.Expense
import kotlinx.coroutines.CoroutineScope

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Expense::class), version = 1, exportSchema = false)
public abstract class SpendingRoomDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var instance: SpendingRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): SpendingRoomDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpendingRoomDatabase::class.java,
                    "spending_database"
                ).addCallback(ExpenseDatabaseCallback(scope, instance)).build()
                SpendingRoomDatabase.instance = instance
                return instance
            }
        }
    }
}