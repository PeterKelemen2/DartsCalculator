package com.example.dartscalculator

import CreateTable
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout


class MainActivity : AppCompatActivity() {

    private val playerList = arrayOf("LOOOONGNAME", "Shortname", "Name")
    private lateinit var headerTableLayout: TableLayout
    private lateinit var scrollTable: TableLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        headerTableLayout = findViewById(R.id.headerTableLayout)
        scrollTable = findViewById(R.id.scrollTable)

        val pointsTable = CreateTable(this, null, playerList, headerTableLayout, scrollTable)
        pointsTable.addHeaderRow(arrayOf("Name1", "Name2", "Name3"))
        for (i in 1 until 100){
            pointsTable.addTableRow("fasz")
        }

    }
}
