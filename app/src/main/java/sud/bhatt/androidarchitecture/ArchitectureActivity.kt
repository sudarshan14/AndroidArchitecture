package sud.bhatt.androidarchitecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import kotlinx.android.synthetic.main.activity_architecture.*
import sud.bhatt.androidarchitecture.mvc.MVCActivity
import sud.bhatt.androidarchitecture.mvp.MVPActivity
import sud.bhatt.androidarchitecture.mvvm.MVVMActivity

class ArchitectureActivity : AppCompatActivity(), OnClickListener {
    //    private val button: Button = findViewById(R.id.buttonMVC)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architecture)
        buttonMVC.setOnClickListener(this)
        buttonMVP.setOnClickListener(this)
        buttonMVVM.setOnClickListener(this)

//        buttonMVC.setOnClickListener {
////            val intent: Intent = Intent(this, MVCActivity::class.java)
//            startActivity(Intent(this, MVCActivity::class.java))
//        }

//        buttonMVP.setPnc;
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonMVC -> startActivity(Intent(this, MVCActivity::class.java))
            R.id.buttonMVP -> startActivity(Intent(this, MVPActivity::class.java))
            R.id.buttonMVVM -> startActivity(Intent(this, MVVMActivity::class.java))
        }
    }
}