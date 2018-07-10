package www.com.httpmanagerframe.dialog;


import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;

import www.com.httpmanagerframe.R;


/**
 * 动画加载对话框
 *
 *
 */
public class AnimationDialog extends Dialog {
	private        Context         context         = null;
	private static AnimationDialog animationDialog = null;
	
	public AnimationDialog(Context context){
		super(context);
		this.context = context;
	}
	
	public AnimationDialog(Context context, int theme) {
        super(context, theme);
        this.context=context;
    }
	
	public static AnimationDialog createDialog(Context context){
		animationDialog = new AnimationDialog(context, R.style.new_circle_progress);
		animationDialog.setContentView(R.layout.animation_play);
//		ImageView ivLoading=(ImageView) animationDialog.findViewById(R.id.iv_anim);
//		Animation animation= AnimationUtils.loadAnimation(context, R.anim.refresh_refreshing);
//		ivLoading.setAnimation(animation);
		animationDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
		return animationDialog;
	}
	
    public void onWindowFocusChanged(boolean hasFocus){
    	if (animationDialog != null){
//    		ImageView imageView = (ImageView) animationDialog.findViewById(R.id.iv_anim);
//    		Animation animation= AnimationUtils.loadAnimation(context, R.anim.refresh_refreshing);
//    		imageView.setAnimation(animation);
    	}
    }
    
    public void flushCache(){
    	context.getResources().flushLayoutCache();
    	animationDialog=null;
    }
}
