/*
 * Copyright (c) 2008, 2010, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores
 * CA 94065 USA or visit www.oracle.com if you need additional information or
 * have any questions.
 */
package com.ascentcomtec.smarthouse.ui.components;

import android.content.Context;
import android.graphics.Typeface;
 

/**
 * A simple abstraction of platform fonts and library fonts that enables the
 * library to use more elaborate fonts unsupported by a specific device.
 * This abstraction also supports bitmap fonts using an Ant task (more details
 * about the unifier are explained in the javadoc overview document).
 * <p>A bitmap font can be created manually but that is tedious, normally you would use
 * the Ant task as illustrated bellow to produce a resource file containing
 * the supported bitmap font. For further detail read the overview document and 
 * {@link com.codename1.ui.util.Resources}.
<pre>
&lt;target name="pre-init"&gt;
     &lt;taskdef classpath="ImageUnifier.jar" classname="com.sun.jwt.resource.Builder" name="build" /&gt;
     &lt;build dest="src/font.res"&gt;
        &lt;font src="images/arial.ttf" bold="true" italic="true" size="11" /&gt;
        &lt;font logicalName="Dialog" /&gt;
    &lt;/build&gt;
&lt;/target&gt;
</pre>
 * <p>The following attributes can be expressed for a font ant task:
 * <ul>
 * <li>name - name for the font to load from the resource file (optional: defaults to logical name or file name).
 * <li>charset - defaults to the English alphabet, numbers and common signs. 
 * Should contain a list of all characters that should be supported by a font. E.g. if a font would always be
 * used for uppercase letters then it would save space to define the charset as: {@code "ABCDEFGHIJKLMNOPQRSTUVWXYZ" }
 * <li>src - font file in the case of using a file, defaults to TrueType font
 * <li>size - floating point size of the font
 * <li>bold - defaults to false indicates if the font should be bold
 * <li>italic - defaults to false indicates if the font should be italic
 * <li>trueType - defaults to true, relevant only when src is used. If set to false type 1 fonts are assumed.
 * <li>antiAliasing - defaults to true otherwise fonts will be aliased
 * <li>logicalName - logical name of the font as specified by java.awt.Font in Java SE: 
 * {@code Dialog, DialogInput, Monospaced, Serif, or SansSerif }
 * </ul>
 */
public class Font {
    /**
     * Constant allowing us to author portable system fonts
     */
    public static final String FACE_LOVEYALIKEASISTER = "helvetica_neue";
    /**
     * Constant allowing us to author portable system fonts
     */
    public static final String FACE_LOVEYALIKEASISTERSOLID = "helvetica_neue";

    /**
     * Constant allowing us to author portable system fonts
     */
    public static final String FACE_UTMCENTUR = "helvetica_neue";

    /**
     * Constant allowing us to author portable system fonts
     */
    public static final int SIZE_LARGE = 16;

    /**
     * Constant allowing us to author portable system fonts
     */
    public static final int SIZE_MEDIUM = 11;

    /**
     * Constant allowing us to author portable system fonts
     */
    public static final int SIZE_SMALL = 9;

    /**
     * Constant allowing us to author portable system fonts
     */
    public static final String STYLE_BOLD = "_bold.ttf";

    /**
     * Constant allowing us to author portable system fonts
     */
    public static final String STYLE_BOLD_ITALIC = "_bold_italic.ttf";
    
    /**
     * Constant allowing us to author portable system fonts
     */
    public static final String STYLE_ITALIC = "_italic.ttf";

    /**
     * Constant allowing us to author portable system fonts
     */
    public static final String STYLE_PLAIN = ".ttf";
    
    private static int _size;
    
    
    /**
     * Creates a new Font
     */
    Font() {
    	
    }
 
    /**
     * Creates a system native font in a similar way to common MIDP fonts
     * 
     * @param face One of FACE_SYSTEM, FACE_PROPORTIONAL, FACE_MONOSPACE
     * @param style one of STYLE_PLAIN, STYLE_ITALIC, STYLE_BOLD
     * @param size One of SIZE_SMALL, SIZE_MEDIUM, SIZE_LARGE
     * @return A newly created system font instance 
     */
	public static Typeface createSystemFont(Context context,String face, String style, int size) {
		_size = size;
 		Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "fonts/" + face + style);
    	return typeFace;
    }
    /***
     * 
     * @return
     */
	public static int getSize() {
		return _size;
	}
}


