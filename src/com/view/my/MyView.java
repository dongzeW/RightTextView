package com.view.my;

import com.example.righttextview.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * ������Զ����TextView. ������Ҫ���ع��췽����onDraw���� �����Զ����View���û���Լ����ص����ԣ�����ֱ����xml�ļ���ʹ�þͿ�����
 * ��������Լ����ص����ԣ���ô����Ҫ�ڹ��캯���л�ȡ�����ļ�attrs.xml���Զ������Ե����� ��������Ҫ�趨Ĭ��ֵ��������xml�ļ���û�ж��塣
 * ���ʹ���Զ������ԣ���ô��Ӧ��xml�ļ�����Ҫ�����µ�schemas��
 * ����������xmlns:my="http://schemas.android.com/apk/res/demo.view.my"
 * ����xmlns��ġ�my�����Զ�������Ե�ǰ׺��res����������Զ���View���ڵİ�
 * 
 * @author Administrator
 * 
 */
public class MyView extends TextView {

	Paint mPaint; // ����,�����˻�����ͼ�Ρ��ı��ȵ���ʽ����ɫ��Ϣ
	private boolean isDraw = false;// �Ƿ�ִ�л��Ʒ���

	public MyView(Context context) {
		super(context);

	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		// TypedArray��һ�����������context.obtainStyledAttributes��õ����Ե�����
		// ��ʹ����ɺ�һ��Ҫ����recycle����
		// ���Ե�������styleable�е�����+��_��+��������
		// TypedArray array = context.obtainStyledAttributes(attrs,
		// R.styleable.MyView);
		// int textColor = array.getColor(R.styleable.MyView_textColorm,
		// 0XFF00FF00); // �ṩĬ��ֵ������δָ��
		// float textSize = array.getDimension(R.styleable.MyView_textSizem,
		// 36);
		// mPaint.setColor(textColor);
		// mPaint.setTextSize(textSize);
		// //
		// array.recycle(); // һ��Ҫ���ã�������ε��趨����´ε�ʹ�����Ӱ��
	}

	public void onDraw(Canvas canvas) {
		if (isDraw) {
			Log.e("wang", "trueҲִ��ondraw");
			return;
		} else {
			isDraw = true;
			Log.e("wang", "ִ��ondraw");
			// Canvas�к��кܶ໭ͼ�Ľӿڣ�������Щ�ӿڣ����ǿ��Ի���������Ҫ��ͼ��
			// mPaint = new Paint();
			// mPaint.setColor(Color.RED);
			mPaint.setStyle(Style.FILL); // �������
			canvas.drawRect(10, 10, 100, 100, mPaint); // ���ƾ���

			mPaint.setColor(Color.BLUE);
			canvas.drawText("���Ǳ���������", 10, 120, mPaint);
		}
	}
}
