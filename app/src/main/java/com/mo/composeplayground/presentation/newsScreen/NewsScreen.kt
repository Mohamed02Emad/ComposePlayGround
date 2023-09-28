package com.mo.composeplayground.presentation.newsScreen

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mo.composeplayground.data.api.RequestState
import com.mo.composeplayground.data.models.Article
import com.mo.composeplayground.presentation.counter.CounterScreen

@Composable
fun NewsScreen(
    activity: Activity?,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val breakingNewsState = viewModel.breakingNews.observeAsState()
    when (breakingNewsState.value) {
        is RequestState.Error -> {
            Toast.makeText(activity, "${breakingNewsState.value?.data?.status}", Toast.LENGTH_SHORT)
                .show()
        }

        is RequestState.Loading -> {}
        is RequestState.Sucess -> {
            NewsList(breakingNewsState.value!!.data!!.articles)
        }

        null -> {}
    }

}

@Composable
fun NewsList(articles: MutableList<Article>) {
    LazyColumn() {
        items(articles.size) {

        }
    }
}

@Composable
fun ArticleNews(modifier : Modifier){
    Column(
        modifier = modifier
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {

}