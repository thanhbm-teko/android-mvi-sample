package vn.phongvu.android.nhanvienphongvu.ui

import androidx.databinding.BindingAdapter
import android.view.View


@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}