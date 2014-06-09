/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.view.my;

// Need the following import to get access to the app resources, since this
// class is in a sub-package.

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Example of how to write a custom subclass of View. LabelView is used to draw
 * simple text views. Note that it does not handle styled text or right-to-left
 * writing systems.
 * 
 */
public class LabelView extends View {
	private Paint mTextPaint;
	private String mText;
	private int mAscent;

	/**
	 * Construct object, initializing with any attributes we understand from a
	 * layout file. These attributes are defined in
	 * SDK/assets/res/any/classes.xml.
	 * 
	 * @see android.view.View#View(android.content.Context,
	 *      android.util.AttributeSet)
	 */
	public LabelView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Log.e("wang", "initview");
		initLabelView();
		mTextPaint = new Paint();
		setText("我们来测试的");
	}

	private final void initLabelView() {

		// mTextPaint.setAntiAlias(true);
		// // Must manually scale the desired text size to match screen density
		 mTextPaint.setTextSize(16 *
		 getResources().getDisplayMetrics().density);
		// mTextPaint.setColor(0xFF000000);
		// setPadding(3, 3, 3, 3);
	}

	/**
	 * Sets the text to display in this label
	 * 
	 * @param text
	 *            The text to display. This will be drawn as one line.
	 */
	public void setText(String text) {
		mText = text;
		// requestLayout();
		Log.e("wang", "settext");
		invalidate();
	}

	/**
	 * Render the text
	 * 
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawText(mText, getPaddingLeft(), 200, mTextPaint);
		Log.e("wang", "ondraw");
	}
}
