package com.example.getimage.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by bearyang on 2016/10/9.
 */

public final class Utils {
	private static final String TAG = Utils.class.getSimpleName();

	public static String getStoragePath(Context context) {
		File sdDir = null;
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			sdDir = Environment.getExternalStorageDirectory();
		}
		String rootPath = null;
		if (sdDir != null && sdDir.canWrite()) {
			rootPath = sdDir.getPath();
		} else {
			rootPath = context.getApplicationContext().getFilesDir().getParent();
		}
		Log.d(TAG, "rootPath: " + rootPath);
		return rootPath + File.separator + "get_image" + File.separator;
	}

	public static File getImageCacheDirectory(Context context) {
		File directory = new File(getStoragePath(context) + "images/");
		if (!directory.exists()) {
			directory.mkdirs();
		}
		return directory;
	}
}
