package com.trichain.expensemanager.room

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.trichain.expensemanager.room.tables.CategoryTable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class OperationActivity : AppCompatActivity() {
    fun insert() {
        val myDb: MyDatabase? = MyDatabase.getInstance(this) // call database
        val note = CategoryTable() //create new note
        note.name = "FirstCategory"
        note.description = "Category  Description"

        CompositeDisposable().add(Observable.fromCallable { myDb?.categoryDao()?.insert(note) }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("respons", "data inserted")
            })
    }

    fun updateDb() {
        val myDb: MyDatabase? = MyDatabase.getInstance(this) // call database
        val note = myDb?.categoryDao()?.getNote(1) // get note
        note?.name = "Edite Titel"
        note?.description = "this is the new description"

        CompositeDisposable().add(Observable.fromCallable {
            if (note != null) {
                myDb?.categoryDao()?.update(note)
            }
        }.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("respons", "data updated")
            })
    }

    fun getCategories() {
        val myDb: MyDatabase? = MyDatabase.getInstance(this) // call database
        val listCategories = myDb?.categoryDao()?.getAllL() // get All data
        if (listCategories != null) {
            listCategories.observe(this, Observer {
                for (note: CategoryTable in it) {
                    println("-----------------------")
                    println(note.name)
                    println(note.description)
                }
            })
        }
    }
}