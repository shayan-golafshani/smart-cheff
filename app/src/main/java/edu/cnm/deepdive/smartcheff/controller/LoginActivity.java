package edu.cnm.deepdive.smartcheff.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.smartcheff.R;
import edu.cnm.deepdive.smartcheff.databinding.ActivityLoginBinding;
import edu.cnm.deepdive.smartcheff.service.GoogleSignInService;

/**
 * This class is the login activity and handles the login of a user.
 */
public class LoginActivity extends AppCompatActivity {

  /**
   * This field is a reference creating a login request code.
   */
  private static final int LOGIN_REQUEST_CODE = 1000;

  /**
   * This field is a reference to the GoogleSignInService class.
   */
    private GoogleSignInService service;

  /**
   * This field is a reference to ActivityLoginBinding.
   */
  private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = GoogleSignInService.getInstance();
        service.refresh()
            .addOnSuccessListener((account) -> switchToMain())
            .addOnFailureListener((throwable) -> {
                binding = ActivityLoginBinding.inflate(getLayoutInflater());
                binding.signIn.setOnClickListener((v) -> service.startSignIn(this, LOGIN_REQUEST_CODE));
                setContentView(binding.getRoot());
            });
    }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == LOGIN_REQUEST_CODE) {
      service.completeSignIn(data)
          .addOnSuccessListener((account) -> switchToMain())
          .addOnFailureListener((throwable) ->
              Toast.makeText(this, R.string.login_failure_message, Toast.LENGTH_LONG).show());
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }

  /**
   * This method is what prompts the login activity to switch to the main activity.
   */
  private void switchToMain (){
      Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

}