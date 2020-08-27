package android.example.com.firstappnew

import android.app.Application
import android.example.com.firstappnew.database.DatabaseDAO
import android.example.com.firstappnew.databinding.FragmentContactBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactViewModelFactory (
    private val dataSource: DatabaseDAO,
    private val binding: FragmentContactBinding,
    private val application: Application
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            return ContactViewModel(dataSource, binding, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}