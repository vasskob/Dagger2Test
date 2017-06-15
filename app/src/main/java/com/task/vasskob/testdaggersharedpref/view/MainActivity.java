package com.task.vasskob.testdaggersharedpref.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.task.vasskob.testdaggersharedpref.MyApplication;
import com.task.vasskob.testdaggersharedpref.R;
import com.task.vasskob.testdaggersharedpref.presenter.PresenterImpl;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.task.vasskob.testdaggersharedpref.Constants.DEFAULT_SAVED_TEXT;

public class MainActivity extends AppCompatActivity implements MyView {

    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Bind(R.id.edit_text)
    EditText etTextToSave;

    @Bind(R.id.pb_loading)
    ProgressBar pbLoading;

    @Inject
    PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MyApplication.getInstance().getMyAppComponent().inject(this);
        presenter.attachView(this);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_save)
    void onSaveClick() {
        pbLoading.setVisibility(View.VISIBLE);
        String text = etTextToSave.getText().toString();
        presenter.saveText(text);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_load)
    void onLoadClick() {
        pbLoading.setVisibility(View.VISIBLE);
        presenter.loadText();
    }

    public void showToast(int key) {
        pbLoading.setVisibility(View.GONE);
        String msg;
        switch (key) {
            case 0:
                msg = getString(R.string.load_error);
                break;
            case 1:
                msg = getString(R.string.load_success);
                break;
            case 2:
                msg = getString(R.string.save_error);
                break;
            case 3:
                msg = getString(R.string.save_success);
                break;
            default:
                msg = DEFAULT_SAVED_TEXT;
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSavedText(String title) {
        tvTitle.setText(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
