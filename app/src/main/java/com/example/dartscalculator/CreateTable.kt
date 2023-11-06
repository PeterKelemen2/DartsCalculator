import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.example.dartscalculator.R
import com.google.android.material.tabs.TabLayout.Tab

class CreateTable(context: Context, attrs: AttributeSet?,
                  private val playerList: Array<String>,
                  private val headerTable: TableLayout,
                  private val scrollTable: TableLayout) : View(context, attrs) {

    fun addHeaderRow(pList: Array<String>) {

        val headerRow = TableRow(context)
        headerRow.gravity = Gravity.CENTER_HORIZONTAL

        for (i in 0 until pList.count()){
            val headerCellText = TextView(context)
            headerCellText.gravity = Gravity.CENTER_HORIZONTAL
            headerCellText.text = pList[i]

            headerCellText.layoutParams = TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT,
                1f
            )

            headerCellText.textSize = 20f
            headerCellText.setTextColor(Color.BLACK)

            headerRow.addView(headerCellText)
        }

        headerTable.addView(headerRow)
    }

    fun addTableRow(rowData: String?) {
        val row = TableRow(context)
        row.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )

        for (i in 0 until playerList.count()) {
            val cell = TextView(context)
            cell.text = rowData

            val cellParams = TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.MATCH_PARENT,
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

        // Add data row to the CreateTable instance
        scrollTable.addView(row)
    }
}
