// Generated code from Butter Knife. Do not modify!
package com.example.demomobilesecurity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HiddenActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.demomobilesecurity.HiddenActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230731, "field 'iv_picture' and method 'browsePicture'");
    target.iv_picture = (android.widget.ImageButton) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.browsePicture();
        }
      });
    view = finder.findRequiredView(source, 2131230735, "method 'viewSMSApps'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.viewSMSApps();
        }
      });
    view = finder.findRequiredView(source, 2131230730, "method 'showSettings'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.showSettings();
        }
      });
    view = finder.findRequiredView(source, 2131230729, "method 'showHiddenFiles'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.showHiddenFiles();
        }
      });
    view = finder.findRequiredView(source, 2131230733, "method 'browseAudio'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.browseAudio();
        }
      });
    view = finder.findRequiredView(source, 2131230734, "method 'browseFile'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.browseFile();
        }
      });
    view = finder.findRequiredView(source, 2131230732, "method 'browseVideo'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.browseVideo();
        }
      });
  }

  public static void reset(com.example.demomobilesecurity.HiddenActivity target) {
    target.iv_picture = null;
  }
}
