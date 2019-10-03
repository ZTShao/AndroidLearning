package com.example.android.zhetai.androidlearning

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import com.example.android.zhetai.androidlearning.Utils.EasySchedulers
import com.example.android.zhetai.androidlearning.Utils.NetworkUtil
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.disposables.CompositeDisposable

class NetworkTestActivity : Activity() {

    private lateinit var webView: WebView
    private lateinit var urlEditText: EditText
    private lateinit var requestButton: Button
    private lateinit var disposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_test)
        disposable = CompositeDisposable()
        webView = findViewById(R.id.webview_test)
        urlEditText = findViewById(R.id.edit_text_url)
        requestButton = findViewById(R.id.button_request_url)
        requestButton.setOnClickListener { _ ->
            val url = "http://" + urlEditText.text.toString()
            disposable.add(
                Single.create(SingleOnSubscribe<String> {
                    it.onSuccess(NetworkUtil.loadURL(url))
                })
                    .subscribeOn(EasySchedulers.io())
                    .observeOn(EasySchedulers.ui())
                    .subscribe { content -> updateWebView(content) }
            )

        }
    }

    private fun updateWebView(content: String) {
        webView.loadData(content, "text/html;charset=utf-8", null)
    }

    inner class LoadNetworkResouceTask(
        private val url: String
    ) : AsyncTask<Any, Any, String>() {

        override fun onPostExecute(result: String?) {
            if (result == null) return
            super.onPostExecute(result)
            webView.loadData(result, "text/html;charset=utf-8", null)
        }

        override fun doInBackground(vararg params: Any?): String? {
            return NetworkUtil.loadURL(url)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}


