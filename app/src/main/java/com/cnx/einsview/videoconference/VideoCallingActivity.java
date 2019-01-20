package com.cnx.einsview.videoconference;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoCallingActivity extends AppCompatActivity {
  @BindView(R.id.tvDeviceId) TextView tvDeviceId;
  @BindView(R.id.tvDeviceIdValue) TextView tvDeviceIdValue;
  @BindView(R.id.etOpponentDeviceId) EditText etOpponentDeviceId;
  @BindView(R.id.button) Button button;
  private String mDeviceId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video_calling);
    ButterKnife.bind(this);

    mDeviceId = getIntent().getStringExtra(getString(R.string.login_key));
    if (mDeviceId != null) {
      tvDeviceIdValue.setText(mDeviceId);
    }
  }
}
