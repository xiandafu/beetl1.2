/*
 [The "BSD license"]
 Copyright (c) 2011-2013 Joel Li (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.bee.tl.ext;

import java.text.DecimalFormat;

import org.bee.tl.core.BeeNumber;
import org.bee.tl.core.Format;
import org.bee.tl.core.number.NumberFactory;

/*格式化Number类型，pattern参考DecimalFormat,如
 * ${0.345,numberFormat="##.#%"}
 * 
 * @author jeolli
 *
 */
public class NumberFormat implements Format {

	public String format(Object data, String pattern) {
		DecimalFormat df = null;
		if (pattern == null) {
			df = new DecimalFormat();
		} else {
			df = new DecimalFormat(pattern);
		}

		if (data instanceof BeeNumber) {
			return df.format(((BeeNumber) data).orginalObject());
		} else {

			return df.format(data);
		}

	}

	public static void main(String[] args) {
		NumberFactory f = new NumberFactory(false);
		BeeNumber n = f.y(12.4464);
		NumberFormat nf = new NumberFormat();
		String str = nf.format(n, "#.##");
		System.out.println(str);
	}

}
