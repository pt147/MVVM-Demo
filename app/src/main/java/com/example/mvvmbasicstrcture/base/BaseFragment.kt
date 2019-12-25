import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    abstract fun layoutID(): Int

    abstract fun viewModel(): BaseViewModel

    abstract fun initFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<T>(inflater, layoutID(), container, false)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel())
        binding.setVariable(BR.handler, this)


        return binding.root
    }

    fun getViewModel() = viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
    }

    fun startActivity(cls: Class<*>) {
        getAct().startActivity(cls)
    }

    private fun getAct(): BaseActivity<*> {
        return activity as BaseActivity<*>
    }

}