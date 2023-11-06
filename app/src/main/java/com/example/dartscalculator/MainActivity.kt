package com.example.dartscalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var headerTableLayout: TableLayout
    private lateinit var scrollTable: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headerTableLayout = findViewById(R.id.headerTableLayout)
        scrollTable = findViewById(R.id.scrollTable)

        addHeaderRow()

        // Add rows dynamically
        for (i in 0 until 100) {
            addTableRow("Row $i")
        }
    }

    private fun addHeaderRow() {
        val headerRow = TableRow(this)

        val cellParams = TableRow.LayoutParams(
            0,
            100,
            1.0f
        )

        for (i in 1 until 6) {
            val headerCellText = TextView(this)
            headerCellText.setTextColor(Color.WHITE)
            headerCellText.text = "Player #$i"
            headerCellText.layoutParams = cellParams
            headerCellText.gravity = Gravity.CENTER
            headerCellText.textSize = 16f
            headerRow.addView(headerCellText)
        }

        headerTableLayout.addView(headerRow)
    }

    private fun addTableRow(rowData: String) {
        val row = TableRow(this)
        row.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )

        for (i in 1 until 6) {
            val cell = TextView(this)
            cell.text = (i * 111).toString()

            val cellParams = TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f
            )

            if (i % 2 == 0) {
                cell.setTextColor(Color.rgb(191, 80, 93))
            } else {
                cell.setTextColor(Color.rgb(14, 199, 45))
            }

            cell.gravity = Gravity.CENTER
            cell.layoutParams = cellParams
            cell.textSize = 20f
            row.addView(cell)
        }

        scrollTable.addView(row)
    }

}