package com.fourmainandroidcomponents.contentproviderapplication

import android.R
import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class SimpleDialogFragment : DialogFragment() {


    companion object {
        const val TAG = "SimpleDialogFragment"

        private const val KEY_VALUES = "KEY_VALUES"

        fun newInstance(values: ArrayList<String>) = SimpleDialogFragment().apply {
            arguments = Bundle().apply {
                putStringArrayList(KEY_VALUES, values)
            }
        }

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val values = arguments?.getStringArrayList(KEY_VALUES)!!

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, values.toTypedArray())


        return AlertDialog.Builder(requireContext())
            .setAdapter(arrayAdapter, null)
            .setPositiveButton(getString(R.string.ok)) { _, _ -> }
            .create()
    }

}