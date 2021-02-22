package com.hacslunar.rams.aboutme

import android.content.Context
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.hacslunar.rams.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nickNameEditText: EditText
    private lateinit var doneButton: Button
    private lateinit var nickNameTextView: TextView
    private var myName: MyName = MyName("Hackeem MMensah")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //connect the databinding object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myName = myName
        // This method instantiate all views of this class.
        // Every view related logic must go under it
        instantiateViews()

        doneButton.setOnClickListener {
            addNickname(it)
        }


    }

    fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nickNameEditText.text.toString()
            invalidateAll()
            view.visibility = View.GONE
            nickNameEditText.visibility = View.GONE
            nickNameTextView.visibility = View.VISIBLE
        }

        val hideKeyBoard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyBoard.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // instantiate all views of this class here
    private fun instantiateViews() {
        nickNameEditText = binding.nicknameEdit
        doneButton = binding.doneButton
        nickNameTextView = binding.nicknameText
    }
}