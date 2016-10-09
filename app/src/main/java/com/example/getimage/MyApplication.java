package com.example.getimage;

import android.app.Application;
import android.content.Context;

import com.example.getimage.utils.Utils;
import com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by bearyang on 2016/10/9.
 */

public class MyApplication extends Application {

	private static final int IMAGE_MEMORY_CACHE_MAX_SIZE = 20 * 1024 * 1024;
	private static final int IMAGE_DISK_CACHE_MAX_SIZE = 50 * 1024 * 1024;

	@Override
	public void onCreate() {
		super.onCreate();
		initMyConfiguration(this);
	}

	private void initDefaultConfiguration(Context context) {
		ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
		ImageLoader.getInstance().init(configuration);
	}

	private void initMyConfiguration(Context context) {
		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
				.threadPoolSize(3)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.memoryCache(new LruMemoryCache(IMAGE_MEMORY_CACHE_MAX_SIZE))
				.denyCacheImageMultipleSizesInMemory()
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.FIFO)
				.diskCache(new LimitedAgeDiskCache(Utils.getImageCacheDirectory(context), IMAGE_DISK_CACHE_MAX_SIZE))
				.build();
		ImageLoader.getInstance().init(configuration);

	}
}
