package example.getpassengers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GetPassengers : AppCompatActivity() {

    var passList: MutableList<Passenger> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_passengers)

        findViewById<Button>(R.id.add_button).setOnClickListener {
            enterPassenger(it)
        }
        findViewById<Button>(R.id.back_to_main).setOnClickListener {
            backToMain(it)
        }
    }

    fun enterPassenger(v: View) {
        var textFirst = findViewById<EditText>(R.id.first_name)
        var textLast = findViewById<EditText>(R.id.last_name)
        var textPhone = findViewById<EditText>(R.id.phone_number)

        var textPut = findViewById<TextView>(R.id.accum_list)

        var firstName = textFirst.getText().toString()
        var lastName = textLast.getText().toString()
        var phone = textPhone.getText().toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && phone.isNotEmpty()) {
            val newPass = Passenger(firstName, lastName, phone)
            passList.add(newPass)

            val updatedList = passList.joinToString("\n") { "${it.fName} ${it.lName}, ${it.phone}" }

            textPut.text = "Accumulating Passenger List:\n-----------------\n$updatedList"


            // Clear values
            textFirst.text.clear()
            textLast.text.clear()
            textPhone.text.clear()
        }
    }


        fun backToMain(v: View) {
            val returnIntent = Intent()


            returnIntent.putExtra("COUNT", passList.size.toString())


            for (i in passList.indices) {
                val key = "PASS${i + 1}"
                returnIntent.putExtra(key, passList[i].toString())
            }

            // Send to MainActivity
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }