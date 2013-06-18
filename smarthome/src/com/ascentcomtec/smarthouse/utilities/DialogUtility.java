/*
 * Name: $RCSfile: DialogUtility.java,v $
 * Version: $Revision: 1.1 $
 * Date: $Date: Nov 14, 2011 9:15:47 AM $
 *
 * Copyright (C) 2011 COMPANY_NAME, Inc. All rights reserved.
 */

package com.ascentcomtec.smarthouse.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public final class DialogUtility {
	public static void alert(Context context, String message, String title,
			String buttonTitle) {
		AlertDialog.Builder alert = new AlertDialog.Builder(context);
		alert.setTitle(title);
		alert.setMessage(message);
		alert.setPositiveButton(buttonTitle,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.cancel();
					}
				});
		alert.show();
	}
}
