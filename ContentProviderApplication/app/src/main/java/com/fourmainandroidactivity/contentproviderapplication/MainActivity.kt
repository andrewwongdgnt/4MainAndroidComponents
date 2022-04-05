package com.fourmainandroidactivity.contentproviderapplication

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.UserDictionary
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.fourmainandroidactivity.contentproviderapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if( applicationContext.checkSelfPermission( Manifest.permission.READ_CONTACTS ) != PackageManager.PERMISSION_GRANTED )
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 1);

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
                    val nameIndex: Int = getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)
                    val hasPhoneNumberIndex: Int = getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)

                    val list = ArrayList(generateSequence { if (moveToNext()) this else null }
                        .map {
                            val name = getString(nameIndex)
                            val hasPhoneNumber = getString(hasPhoneNumberIndex)
                            val value = "name: $name, hasPhoneNumber: $hasPhoneNumber"

                            Log.d("ContentProvider", value)
                            value
                        }
                        .toList())

                    ContactsDialogFragment.newInstance(list).show(supportFragmentManager, ContactsDialogFragment.TAG)

                    close()
                }

            }


            setContentView(root)
        }


    }
}