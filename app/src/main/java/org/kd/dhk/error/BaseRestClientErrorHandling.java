package org.kd.dhk.error;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.api.rest.RestErrorHandler;
import org.springframework.core.NestedRuntimeException;

/**
 * 代号:隐无为
 * 时间:2016/1/29
 * 用途：
 */
@EBean
public class BaseRestClientErrorHandling  implements RestErrorHandler {
  @RootContext
  Context context;

  @Override
  public void onRestClientExceptionThrown(NestedRuntimeException e) {
    Log.d("REST", e.toString());
    showError();
  }
  @UiThread
  void showError(){
    Toast.makeText(context, "Rest Error...", Toast.LENGTH_SHORT).show();
  }
}
