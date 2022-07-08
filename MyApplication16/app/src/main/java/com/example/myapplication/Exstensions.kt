import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun ViewGroup.inflateView(@LayoutRes resId: Int): View {
    return LayoutInflater.from(this.context).inflate(resId, this, false)
}

fun ImageView.loadFromUrl(imgUrl: String?) {
    Glide.with(this)
        .load(imgUrl)
        .into(this)
}