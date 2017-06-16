package com.task.vasskob.testdaggersharedpref;

import com.task.vasskob.testdaggersharedpref.model.repository.PrefsRepository;
import com.task.vasskob.testdaggersharedpref.model.repository.Repository;
import com.task.vasskob.testdaggersharedpref.presenter.PresenterImpl;
import com.task.vasskob.testdaggersharedpref.view.MyView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.task.vasskob.testdaggersharedpref.Constants.ERROR;
import static com.task.vasskob.testdaggersharedpref.Constants.LOAD_ERROR;
import static com.task.vasskob.testdaggersharedpref.Constants.LOAD_SUCCESS;
import static com.task.vasskob.testdaggersharedpref.Constants.SAVE_ERROR;
import static com.task.vasskob.testdaggersharedpref.Constants.SAVE_SUCCESS;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public class PresenterTest {

    @Mock
    PrefsRepository mockPrefsRepository;

    @Mock
    MyView mockView;

    private PresenterImpl presenter;
    private static final String TEST_STRING = "TEST_STRING";

    @Captor
    private ArgumentCaptor<Repository.OnLoadListener<String>> mLoadListenerCaptor;

    @Captor
    private ArgumentCaptor<Repository.OnSavedListener> mSavedListenerCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        presenter = new PresenterImpl(mockPrefsRepository);
        presenter.attachView(mockView);
    }

    @Test
    public void saveStringToRepository() {
        presenter.saveText(TEST_STRING);

        verify(mockPrefsRepository).add(eq(TEST_STRING), mSavedListenerCaptor.capture());
        mSavedListenerCaptor.getValue().onSaved();

        verify(mockView).showToast(SAVE_SUCCESS);
    }

    @Test
    public void saveStringToRepositoryWithError() {
        presenter.saveText(TEST_STRING);

        verify(mockPrefsRepository).add(eq(TEST_STRING), mSavedListenerCaptor.capture());
        mSavedListenerCaptor.getValue().onError(ERROR);

        verify(mockView).showToast(SAVE_ERROR);
    }

    @Test
    public void loadStringFromRepositoryAndLoadIntoView() {
        presenter.loadText();

        verify(mockPrefsRepository).get(mLoadListenerCaptor.capture());
        mLoadListenerCaptor.getValue().onLoaded(TEST_STRING);

        verify(mockView).showSavedText(TEST_STRING);
        verify(mockView).showToast(LOAD_SUCCESS);
    }

    @Test
    public void loadStringFromRepositoryAndLoadIntoViewWithError() {
        presenter.loadText();

        verify(mockPrefsRepository).get(mLoadListenerCaptor.capture());
        mLoadListenerCaptor.getValue().onError(TEST_STRING);

        verify(mockView).showToast(LOAD_ERROR);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenViewIsNull() {
        // Null out the view
        presenter.attachView(null);

        // Try to load the text which will force interactions with the view
        presenter.loadText();

        verify(mockPrefsRepository).get(mLoadListenerCaptor.capture());
        mLoadListenerCaptor.getValue().onLoaded(TEST_STRING);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenViewIsDetached() {
        // Null out the view
        presenter.detachView();

        // Try to load the text which will force interactions with the view
        presenter.loadText();

        verify(mockPrefsRepository).get(mLoadListenerCaptor.capture());
        mLoadListenerCaptor.getValue().onLoaded(TEST_STRING);
    }
}
