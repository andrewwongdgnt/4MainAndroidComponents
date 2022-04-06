package com.fourmainandroidcomponents.contentproviderotherapplication

import android.R.id
import android.content.ContentProvider
import android.content.ContentResolver
import android.content.ContentUris
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.widget.Toast


class MyContentProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 3
    }

    override fun getType(uri: Uri): String? {
        return "${ContentResolver.CURSOR_DIR_BASE_TYPE}/vnd.de.openminds.lentitems_items.xxx"
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return ContentUris.withAppendedId(uri, 2)
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor {

        val  cursor = MatrixCursor( arrayOf("Col1", "Col2", "Col3"))

        (1..10).forEach { i ->
            cursor.addRow(arrayOf("A$i", "B$i", "C$i"))
        }
        return cursor
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 5
    }
}