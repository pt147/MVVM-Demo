import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mvvmbasicstrcture.BR
import com.example.mvvmbasicstrcture.R
import java.io.Serializable

/*
*
*   This activity is the base of all activity, While extending it to another activity
*   please pass corresponding activity's auto generated Data Binding Class.
*   also please do not forgot to pass ViewModel as we have use ViewModel in XML.
*
*/

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {


    abstract fun layoutID(): Int

    abstract fun viewModel(): BaseViewModel

    abstract fun initActivity(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<T>(this, layoutID())
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel())
        binding.setVariable(BR.handler, this)

        initActivity(savedInstanceState)


    }

    fun getViewModel(): Any = viewModel()

    fun startActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        overridePendingTransitionEnter()
    }

    fun startActivityWithData(cls: Class<*>, obj: Any) {
        val intent = Intent(this, cls)
        if (obj is Serializable) intent.putExtra("Extras", obj)
        startActivity(intent)
        overridePendingTransitionEnter()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransitionExit()
    }

    /* protected fun initToolbar(
         title: String = "",
         headingColor: Int = R.color.colorPrimary,
         backButtonColor: Int = R.color.colorPrimary,
         semiTitle: String = "",
         colorBgToolbar: Int = android.R.color.transparent
     ) {
         setSupportActionBar(toolbar)
         supportActionBar?.let {
             val drawable: Drawable? = getDrawable(R.drawable.ic_left_arrow)
             drawable?.setTint(ContextCompat.getColor(this, backButtonColor))
             it.setHomeAsUpIndicator(drawable)
             it.setDisplayShowTitleEnabled(false)
             it.setDisplayHomeAsUpEnabled(true)
             it.setDisplayShowHomeEnabled(true)
         }
         toolbar.setBackgroundColor(ContextCompat.getColor(this, colorBgToolbar))
         toolbar.setNavigationOnClickListener { v -> onBackPressed() }
         tv_heading.text = title
         tv_extra.text = semiTitle
         tv_heading.setTextColor(ContextCompat.getColor(this, headingColor))
     }*/

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */


    private fun overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    private fun overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    fun overridePendingTransitionDown() {
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down)
    }

    protected fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}