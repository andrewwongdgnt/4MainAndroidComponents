package com.fourmainandroidcomponents.contentproviderapplication

import android.R
import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class ContactsDialogFragment : DialogFragment() {


    companion object {
        const val TAG = "ContactsDialogFragment"

        private const val KEY_VALUES = "KEY_VALUES"

        fun newInstance(values: ArrayList<String>) = ContactsDialogFragment().apply {
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