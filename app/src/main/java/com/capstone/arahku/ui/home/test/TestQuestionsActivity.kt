package com.capstone.arahku.ui.home.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.adapter.QuestionAdapter
import com.capstone.arahku.databinding.ActivityTestQuestionsBinding
import com.capstone.arahku.model.response.FieldsItemForm
import com.capstone.arahku.viewmodel.QuestionViewModel

class TestQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestQuestionsBinding
    private lateinit var questionViewModel: QuestionViewModel
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelSetup()

    }

    private fun viewModelSetup(){
        questionViewModel = ViewModelProvider(this@TestQuestionsActivity)[QuestionViewModel::class.java]

        questionViewModel.apply {
            getForm()
            question.observe(this@TestQuestionsActivity){questionList ->
                setData(questionList)
            }
        }

    }

    private fun setData(question: List<FieldsItemForm?>?){
        rv = binding.rvQuestion
        val adapter = QuestionAdapter(question)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this@TestQuestionsActivity)
    }
}