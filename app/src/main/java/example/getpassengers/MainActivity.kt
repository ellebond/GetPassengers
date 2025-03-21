package example.getpassengers

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var listText: TextView

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val count = data?.getStringExtra("COUNT")?.toIntOrNull() ?: 0
                val passengers = mutableListOf<String>()


                for (i in 1..count) {
                    val passengerData = data?.getStringExtra("PASS$i") ?: continue
                    passengers.add(passengerData)
                }


                if (passengers.isNotEmpty()) {
                    listText.text = "Returned Passenger List:\n" + passengers.joinToString("\n")
                } else {
                    listText.text = "No passengers available."
                }
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listText = findViewById(R.id.show_list)

    }
    fun getList(v: View) {

        listText.text = "Returned Passenger List:"


        val intent = Intent(this, GetPassengers::class.java)
        startForResult.launch(intent)
    }
}

