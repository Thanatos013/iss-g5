// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230737, "field 'passwordText'");
    target.passwordText = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131230738, "field 'createpass' and method 'createPassword'");
    target.createpass = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.createPassword();
        }
      });
    view = finder.findRequiredView(source, 2131230739, "field 'viewFile' and method 'viewFiles'");
    target.viewFile = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.viewFiles();
        }
      });
  }

  public static void reset(com.example.demomobilesecurity.MainActivity target) {
    target.passwordText = null;
    target.createpass = null;
    target.viewFile = null;
  }
}