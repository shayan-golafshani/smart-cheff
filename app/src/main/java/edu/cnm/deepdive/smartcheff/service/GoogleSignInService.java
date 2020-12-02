package edu.cnm.deepdive.smartcheff.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
import edu.cnm.deepdive.smartcheff.BuildConfig;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

/**
 * This class holds all the logic for the google sign in function.
 */
public class GoogleSignInService {

  private static Application context;

  private final GoogleSignInClient client;

  private  GoogleSignInAccount account;

  private GoogleSignInService() {
    GoogleSignInOptions options  = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
//        .requestIdToken(BuildConfig.CLIENT_ID)
        .build();
    client = GoogleSignIn.getClient(context, options);
  }

  /**
   * This is the t setter for the google sign in context.
   */
  public static void setContext(Application context) {
    GoogleSignInService.context = context;
  }

  /**
   * This is the getter for the google sign service instance.
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * This is the getter for the account.
   */
  public GoogleSignInAccount getAccount() {
    return account;
  }

  /**
   * This method refreshes the google sign in.
   */
  public Task<GoogleSignInAccount> refresh() {
    return client.silentSignIn()
        .addOnSuccessListener(this::setAccount);
  }

  /**
   * This method is starts the sign in with a google account.
   * @param activity is a reference to the Activity class.
   * @param requestCode is the google sign in request code.
   */
  public void startSignIn(Activity activity, int requestCode) {
    account = null;
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * This method completes the sign in of a google account.
   * @param data is a reference to th Intent class
   * @return the google sign in task.
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      setAccount(task.getResult(ApiException.class));
    } catch (ApiException e) {
      // Exception will be passed automatically to onFailureListener.
    }
    return task;
  }

  /**
   * This method signs the user out.
   * @return a null account.
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((ignored) -> setAccount(null));
  }

  /**
   * This is the Setter for a google account.
   * @param account
   */
  private void setAccount(GoogleSignInAccount account) {
    this.account = account;
//    if (account != null) {
      //noinspection ConstantConditions
     // Log.d(getClass().getSimpleName(), account.getIdToken());
//    }
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}
