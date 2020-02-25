package com.mz.spendingmanager.model

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mz.spendingmanager.model.entity.Expense
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ExpenseDatabaseCallback(
    private val scope: CoroutineScope,
    private val instance: SpendingRoomDatabase?
) : RoomDatabase.Callback() {

    //called on database creation
    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
        instance?.let { database ->
            scope.launch {
                var expenseDao = database.expenseDao()

                // Delete all content here.
                expenseDao.deleteAll()

                // Add sample words.
                var expense = Expense("Test")
                expenseDao.insert(expense)
            }
        }
    }
}