package br.cericatto.gok.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.cericatto.gok.R

enum class GokApiStatus { LOADING, ERROR, DONE }

@BindingAdapter("gokApiStatus")
fun bindApiStatus(statusImageView: ImageView, status: GokApiStatus?) {
    when (status) {
        GokApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        GokApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        GokApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
