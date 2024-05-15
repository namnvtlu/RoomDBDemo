package com.namnv.tlu.android.roomdbdemo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.namnv.tlu.android.roomdbdemo.data.Word;
import com.namnv.tlu.android.roomdbdemo.data.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mWordRepository;
    private final LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application){
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() { return mAllWords; }

    public void insert (Word word){
        mWordRepository.insert(word);
    }
}
