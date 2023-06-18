package com.blind.presenter.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.blind.databinding.ActivityInputBinding
import com.blind.domain.model.Content
import com.blind.presenter.viewmodel.InputViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable

@AndroidEntryPoint
class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    private val viewModel: InputViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
            lifecycleOwner = this@InputActivity
            viewModel = this@InputActivity.viewModel
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent.intentSerializable(ITEM, Content::class.java)?.let {
            viewModel.initData(it)
        }

        observeViewModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun <T: Serializable> Intent.intentSerializable(key: String, clazz: Class<T>): T? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            this.getSerializableExtra(key, clazz)
        } else {
            this.getSerializableExtra(key) as T?
        }
    }

    private fun observeViewModel() {
        viewModel.doneEvent.observe(this) {
            Toast.makeText(this, it.second, Toast.LENGTH_SHORT).show()
            if (it.first) {
                finish()
            }
        }
    }

    companion object {
        private const val ITEM = "item"

        fun start(context: Context, item: Content? = null) {
            Intent(context, InputActivity::class.java).apply {
                putExtra(ITEM, item)
            }.run {
                context.startActivity(this)
            }
        }
    }
}