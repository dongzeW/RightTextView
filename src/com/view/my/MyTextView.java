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
	public static float lineSpacing = 1.3f;// �����еļ��
	private float spacing = 0;
	String nameString = "���������ƺ�֮ˮ����������������������.�������������������׷���������˿ĺ��ѩ��"
			+ "���������뾡����Īʹ���׿ն��¡�";

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// attrs.getAttributeIntValue(,);
		paint1 = new Paint();
	}

	int lineCount = 0;

	@Override
	protected void onDraw(Canvas canvas) {
		Log.e("wang", "ִ��ondraw");
		View view = (View) this.getParent();
		textShowWidth = view.getMeasuredWidth();// �˴���padding marging������attrs���ȡ
		if (TextUtils.isEmpty(nameString)) {
			return;
		}
		char[] textCharArray = nameString.toCharArray();
		// �ѻ��ƵĿ��
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
			if (textCharArray[i] > 127 && textCharArray[i] != '��'
					&& textCharArray[i] != '��' && textCharArray[i] != '��'
					&& textCharArray[i] != '��' && textCharArray[i] != '��') {
				drawedWidth += charWidth + spacing;

			} else {
				drawedWidth += charWidth;
			}
		}
		// setHeight((int) ((lineCount + 1) * (int) 24 * lineSpacing + 10));
		// //ǧ������������ã���ΪsetHeight����������invalidate������������ʹonDraw����
		// ��ѭ��,������onDraw�����invalidate����ָ��textview�Ŀ��
	}

}
