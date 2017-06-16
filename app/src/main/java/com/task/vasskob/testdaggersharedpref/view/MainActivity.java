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

public class MainActivity extends AppCompatActivity implements MyView {

    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Bind(R.id.edit_text)
    EditText etTextToSave;

    @Bind(R.id.pb_loading)
    ProgressBar pbLoading;

    @Inject
    PresenterImpl presenter;
    private String toastMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MyApplication.getInstance().getActivityComponent().inject(this);
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

    @Override
    public void showLoadSuccessToast() {
        toastMsg = getString(R.string.load_success);
        showToast(toastMsg);
    }

    @Override
    public void showLoadErrorToast() {
        toastMsg = getString(R.string.load_error);
        showToast(toastMsg);
    }

    @Override
    public void showSaveSuccessToast() {
        toastMsg = getString(R.string.save_success);
        showToast(toastMsg);
    }

    @Override
    public void showSaveErrorToast() {
        toastMsg = getString(R.string.save_error);
        showToast(toastMsg);
    }

    public void showToast(String msg) {
        pbLoading.setVisibility(View.GONE);
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
        MyApplication.getInstance().clearActivityComponent();
    }
}
