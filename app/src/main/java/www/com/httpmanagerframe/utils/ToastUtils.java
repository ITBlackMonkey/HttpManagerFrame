package www.com.httpmanagerframe.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import www.com.httpmanagerframe.R;


public class ToastUtils {

	private ToastUtils() {
		throw new AssertionError();
	}

	public static void show(Context context, int resId) {
		Toast toast = Toast.makeText(context, context.getResources().getText(resId), Toast.LENGTH_SHORT);
		View view = toast.getView();
		view.setBackgroundResource(R.color.index_now);
		toast.setView(view);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		//show(context, context.getResources().getText(resId), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, int resId, int duration) {
		show(context, context.getResources().getText(resId), duration);
	}

	public static void show(Context context, CharSequence text) {
		Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		View view = toast.getView();
		view.setBackgroundResource(R.color.index_now);//#358395
		toast.setView(view);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		//show(context, text, Toast.LENGTH_SHORT);
	}

	public static void show(Context context, CharSequence text, int duration) {
		Toast toast = Toast.makeText(context, text, duration);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

	public static void show(Context context, int resId, Object... args) {
		show(context, String.format(context.getResources().getString(resId), args), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, String format, Object... args) {
		show(context, String.format(format, args), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, int resId, int duration, Object... args) {
		show(context, String.format(context.getResources().getString(resId), args), duration);
	}

	public static void show(Context context, String format, int duration, Object... args) {
		show(context, String.format(format, args), duration);
	}


}
