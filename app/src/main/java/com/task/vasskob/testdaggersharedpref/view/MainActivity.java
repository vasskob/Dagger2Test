package com.task.vasskob.testdaggersharedpref.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.task.vasskob.testdaggersharedpref.R;
import com.task.vasskob.testdaggersharedpref.presenter.PresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MyView {

    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Bind(R.id.edit_text)
    EditText etTextToSave;

    PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        presenter = new PresenterImpl(MainActivity.this);
        presenter.attachView(this);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_save)
    void onSaveClick() {
        String text = etTextToSave.getText().toString();
        presenter.saveText(text);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_load)
    void onLoadClick() {
        presenter.loadText();
    }


    @Override
    public void showLoadSuccessToast() {
        showToast(getString(R.string.load_success));
    }

    @Override
    public void showSaveSuccessToast() {
        showToast(getString(R.string.save_success));

    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showSavedText(String title) {
        tvTitle.setText(title);
        showToast(getString(R.string.load_success));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
