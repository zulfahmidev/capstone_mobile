package com.capstone.arahku.ui.home.test

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.adapter.QuestionAdapter
import com.capstone.arahku.databinding.ActivityTestQuestionsBinding
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.model.response.FieldsItemForm
import com.capstone.arahku.model.response.ResponsesItem
import com.capstone.arahku.model.response.SendResponse
import com.capstone.arahku.viewmodel.QuestionViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory

class TestQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestQuestionsBinding
    private lateinit var questionViewModel: QuestionViewModel
    private lateinit var rv: RecyclerView
    private lateinit var questionAdapter: QuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModelSetup()
        binding.btnSubmit.setOnClickListener {
            val responseItem = mutableListOf<ResponsesItem>()
            for (items in questionAdapter.getItems()!!){
                val fieldsId = items?.id
                val optionsId = items?.selectedOptionId
                responseItem.add(ResponsesItem(fieldsId, optionsId))
            }
            questionViewModel.apply {
                formId.observe(this@TestQuestionsActivity){formId ->
                    getId().observe(this@TestQuestionsActivity){ userId ->
                        val body = SendResponse(userId, formId, responseItem)
                        sendResponse(body)
                    }
                }

                receivedResponse.observe(this@TestQuestionsActivity){response ->
                    val result = response.data?.result
                    val user = response.data?.userId?.name

                    responseStatus.observe(this@TestQuestionsActivity){success ->
                        if (success){
                            val intent = Intent(this@TestQuestionsActivity, TestResultActivity::class.java)
                            intent.putExtra("result", result)
                            intent.putExtra("username", user)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this@TestQuestionsActivity, "Gagal memuat hasil", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

    }


    private fun viewModelSetup(){
        val pref = UserPreference.getInstance(dataStore)
        questionViewModel = ViewModelProvider(this@TestQuestionsActivity, ViewModelFactory(pref))[QuestionViewModel::class.java]

        questionViewModel.apply {
            question.observe(this@TestQuestionsActivity){questionList ->
                setData(questionList)
            }

            isLoading.observe(this@TestQuestionsActivity){
                showLoading(it)
            }
        }

    }


    private fun setData(question: List<FieldsItemForm?>?){
        rv = binding.rvQuestion
        questionAdapter = QuestionAdapter(question)
        rv.adapter = questionAdapter
        rv.layoutManager = LinearLayoutManager(this@TestQuestionsActivity)
    }

    private fun showLoading(isLoading: Boolean){
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}