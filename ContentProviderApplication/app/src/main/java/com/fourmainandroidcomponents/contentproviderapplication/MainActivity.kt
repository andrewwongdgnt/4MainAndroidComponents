package com.fourmainandroidcomponents.contentproviderapplication

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.fourmainandroidcomponents.contentproviderapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (applicationContext.checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 1)


        ActivityMainBinding.inflate(layoutInflater).run {

            getContacts.setOnClickListener {
                val cursor = contentResolver.query(
                    ContactsContract.Contacts.CONTENT_URI,
                    arrayOf(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY, ContactsContract.Contacts.HAS_PHONE_NUMBER),
                    null,
                    null,
                    "${ContactsContract.Contacts.DISPLAY_NAME_PRIMARY} ASC"
                )

                cursor?.apply {
                    val nameIndex = getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)
                    val hasPhoneNumberIndex = getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)

                    val list = ArrayList(generateSequence { if (moveToNext()) this else null }
                        .map {
                            val name = getString(nameIndex)
                            val hasPhoneNumber = getString(hasPhoneNumberIndex)
                            "name: $name, hasPhoneNumber: $hasPhoneNumber"
                        }
                        .toList())

                    SimpleDialogFragment.newInstance(list).show(supportFragmentManager, SimpleDialogFragment.TAG)

                    close()
                }

            }

            getCustom.setOnClickListener {
                val cursor = contentResolver.query(
                    Uri.parse("content://com.fourmainandroidcomponents.contentproviderotherapplication/xxx"),
                    arrayOf("Col4", "Col5", "Col6"),
                    "ColY = ?",
                    arrayOf("Y"),
                    "Col4 ASC"
                )

                cursor?.apply {
                    val col1Index = getColumnIndex("Col1")
                    val col2Index = getColumnIndex("Col2")
                    val col3Index = getColumnIndex("Col3")

                    val list = ArrayList(generateSequence { if (moveToNext()) this else null }
                        .map {
                            val val1 = getString(col1Index)
                            val val2 = getString(col2Index)
                            val val3 = getString(col3Index)
                            "val1: $val1, val2: $val2, val3: $val3"
                        }
                        .toList())

                    SimpleDialogFragment.newInstance(list).show(supportFragmentManager, SimpleDialogFragment.TAG)

                    close()
                }

            }

            addCustom.setOnClickListener {
                val uri = contentResolver.insert(Uri.parse("content://com.fourmainandroidcomponents.contentproviderotherapplication/xxx"), ContentValues().apply {
                    put("Col1", "ValA")
                    put("Col2", "ValB")
                    put("Col3", "ValC")
                })

                SimpleDialogFragment.newInstance(arrayListOf(uri.toString())).show(supportFragmentManager, SimpleDialogFragment.TAG)
            }

            updateCustom.setOnClickListener {
                val updatedRows = contentResolver.update(Uri.parse("content://com.fourmainandroidcomponents.contentproviderotherapplication/xxx"), ContentValues().apply {
                    put("Col1", "ValA")
                    put("Col2", "ValB")
                    put("Col3", "ValC")
                }, "ColX = ?", arrayOf("X"))

                SimpleDialogFragment.newInstance(arrayListOf(updatedRows.toString())).show(supportFragmentManager, SimpleDialogFragment.TAG)
            }

            deleteCustom.setOnClickListener {
                val updatedRows = contentResolver.delete(Uri.parse("content://com.fourmainandroidcomponents.contentproviderotherapplication/xxx"), "ColZ = ?", arrayOf("Z"))
                SimpleDialogFragment.newInstance(arrayListOf(updatedRows.toString())).show(supportFragmentManager, SimpleDialogFragment.TAG)
            }

            setContentView(root)
        }


    }
}