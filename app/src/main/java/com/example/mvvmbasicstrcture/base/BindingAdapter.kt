import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView


open class BindingAdapter<T>(
    val layoutId: Int,
    val br: Int = -1,
    var list: ArrayList<T>? = null,
    var clickListener: ((View, Int) -> Unit)? = null,
    var longClickListener: ((View, Int) -> Unit)? = null
) : RecyclerView.Adapter<BindingAdapter<T>.ViewHolder>() {

    override fun getItemCount() = list?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (br != -1) holder.binding.setVariable(br, list!![holder.adapterPosition])
        holder.binding.setVariable(
            BR.click,
            View.OnClickListener { v -> clickListener?.invoke(v!!, holder.adapterPosition) })

        holder.binding.setVariable(
            BR.longClick,
            View.OnLongClickListener { v ->
                longClickListener?.invoke(v!!, holder.adapterPosition)
                true
            })



        holder.binding.executePendingBindings()
    }


    fun setData(data: List<T>) {
        list?.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}