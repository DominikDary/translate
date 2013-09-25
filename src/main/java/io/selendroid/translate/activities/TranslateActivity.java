/*
 * Copyright 2012-2013 eBay Software Foundation and selendroid committers.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.selendroid.translate.activities;

import io.selendroid.translate.R;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TranslateActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(io.selendroid.translate.R.layout.translate_activity);
  }

  public void translateKeyword(View view) {
    String key = ((EditText) findViewById(R.id.translationKeyInput)).getText().toString();

    ((TextView) findViewById(R.id.translationOutput)).setText(getLocalizedString(key));
  }

  private String getLocalizedString(String l10nKey) {
    int resourceId = this.getResources().getIdentifier(l10nKey, "string", this.getPackageName());
    try {
      return this.getResources().getString(resourceId);
    } catch (Resources.NotFoundException e) {
      return "";
    }
  }
}
