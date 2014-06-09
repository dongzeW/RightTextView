package com.view.my;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MyRTextView extends TextView {

	private String text = "";
	private float textShowWidth;
	private Paint paint1 = new Paint();
	private float lineSpacing = 1.3f;// 行与行的间距
	private float spacing = 0;

	public MyRTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MyRTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		// attrs.getAttributeIntValue(,);
	}

	public MyRTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Log.e("wang", "执行ondraw");
		View view = (View) this.getParent();
		textShowWidth = view.getMeasuredWidth();// 此处的padding marging可以在attrs里获取
		text = this.getText().toString();
		if (TextUtils.isEmpty(text)) {
			return;
		}
		char[] textCharArrayLeft = text.toCharArray();
		int lineCount = 0;
		// 已绘制的宽度
		float drawedWidth = 0;
		float charWidth;
		changeLocation(textCharArrayLeft);
		Log.e("wang", "text" + text.length());
		char[] textCharArray = rightString.toString().toCharArray();
		Log.e("wang", "rightString" + rightString.length());
		Log.e("wang", rightString.toString());
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
		// setHeight((int) ((lineCount + 1) * (int) 24 * lineSpacing + 10));//
		// 设置当前text的高度
	}

	/**
	 * 控制一行的text反转
	 */
	private void changeLocation(char[] textCharArray) {
		// 已绘制的宽度
		float drawedWidth = 0;
		float charWidth;

		StringBuffer leftString = new StringBuffer();
		int number = 0;
		for (int i = 0; i < textCharArray.length; i++) {
			charWidth = paint1.measureText(textCharArray, i, 1);
			if (textCharArray[i] == '\n') {
				drawedWidth = 0;
				continue;
			}
			// 置换一行的，不足一行的需要特殊处理
			if (textShowWidth - drawedWidth < charWidth) {
				drawedWidth = 0;
				getRihtString(leftString.toString());
				leftString.setLength(0);
				number = i;// 只取了200个字符
			}
			leftString.append(textCharArray[i]);
			if (textCharArray[i] > 127 && textCharArray[i] != '、'
					&& textCharArray[i] != '，' && textCharArray[i] != '。'
					&& textCharArray[i] != '：' && textCharArray[i] != '！') {
				drawedWidth += charWidth + spacing;
			} else {
				drawedWidth += charWidth;
			}
		}
		if (number == 0 || number < textCharArray.length) {
			leftString.setLength(0);
			for (int i = number; i < textCharArray.length; i++) {
				leftString.append(textCharArray[i]);
			}
			getRihtString(leftString.toString());
		}
		Log.e("wang", "number" + number);
	}

	StringBuffer rightString = new StringBuffer();

	private String getRihtString(String leftStr) {
		char[] sc = leftStr.toCharArray();
		for (int i = sc.length - 1; i >= 0; i--) {
			rightString.append(sc[i]);
		}
		return rightString.toString();
	}
}
