package sud.bhatt.androidarchitecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_architecture.*
import sud.bhatt.androidarchitecture.mvc.MVCActivity

class ArchitectureActivity : AppCompatActivity() {
    //    private val button: Button = findViewById(R.id.buttonMVC)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architecture)

        buttonMVC.setOnClickListener {
//            val intent: Intent = Intent(this, MVCActivity::class.java)
            startActivity(Intent(this, MVCActivity::class.java))
        }
    }
}