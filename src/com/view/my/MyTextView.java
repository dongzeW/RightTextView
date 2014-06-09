package com.view.my;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MyTextView extends TextView {

	private float textShowWidth;
	private Paint paint1;
	public static float lineSpacing = 1.3f;// 行与行的间距
	private float spacing = 0;
	String nameString = "君不见，黄河之水天上来，奔流到海不复回.君不见，高堂明镜悲白发，朝如青丝暮成雪。"
			+ "人生得意须尽欢，莫使金樽空对月。";

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// attrs.getAttributeIntValue(,);
		paint1 = new Paint();
	}

	int lineCount = 0;

	@Override
	protected void onDraw(Canvas canvas) {
		Log.e("wang", "执行ondraw");
		View view = (View) this.getParent();
		textShowWidth = view.getMeasuredWidth();// 此处的padding marging可以在attrs里获取
		if (TextUtils.isEmpty(nameString)) {
			return;
		}
		char[] textCharArray = nameString.toCharArray();
		// 已绘制的宽度
		float drawedWidth = 0;
		float charWidth;
		for (int i = 0; i < textCharArray.length; i++) {
			charWidth = paint1.measureText(textCharArray, i, 1);
			if (textCharArray[i] == '\n') {
				lineCount++;
				drawedWidth = 0;
				continue;
			}
			if (textShowWidth - drawedWidth < charWidth) {
				lineCount++;
				drawedWidth = 0;
			}
			canvas.drawText(textCharArray, i, 1, textShowWidth - drawedWidth
					- charWidth, (lineCount + 1) * 24 * lineSpacing, paint1);
			if (textCharArray[i] > 127 && textCharArray[i] != '、'
					&& textCharArray[i] != '，' && textCharArray[i] != '。'
					&& textCharArray[i] != '：' && textCharArray[i] != '！') {
				drawedWidth += charWidth + spacing;

			} else {
				drawedWidth += charWidth;
			}
		}
		// setHeight((int) ((lineCount + 1) * (int) 24 * lineSpacing + 10));
		// //千万不能在这里调用，因为setHeight方法调用了invalidate（）方法，会使onDraw进入
		// 死循环,不能在onDraw里调用invalidate，先指定textview的宽度
	}

}
