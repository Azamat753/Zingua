package com.lawlett.zingua.core.extensions

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> Context.createDialog(
  inflate: (LayoutInflater, ViewGroup?, Boolean) -> T,
): Pair<T, Dialog> {
  val inflater: LayoutInflater = LayoutInflater.from(this)
  val binding = inflate.invoke(inflater, null, false)
  val dialog = Dialog(this)
  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
  dialog.setContentView(binding.root)
  dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
  dialog.show()
  return Pair(binding, dialog)
}