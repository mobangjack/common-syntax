/**
 * Copyright (c) 2011-2015, Mobangjack 莫帮杰 (mobangjack@foxmail.com).
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
package com.syntax;

import java.util.Map;

/**
 * Common condition type constructor
 * @author 帮杰
 *
 */
public class Conditions {

	protected String keyQuote = "";
	protected String valQuote = "";
	protected StringBuilder sb = new StringBuilder();
	
	public Conditions() {}
	
	public Conditions(String keyQuote,String valQuote) {
		this.keyQuote = keyQuote;
		this.valQuote = valQuote;
	}

	public Conditions(Map<String, Object> map,String compareSymbol) {
		this();
		add(map, compareSymbol);
	}
	
	public String getKeyQuote() {
		return keyQuote;
	}

	public Conditions setKeyQuote(String keyQuote) {
		this.keyQuote = keyQuote;
		return this;
	}

	public String getValQuote() {
		return valQuote;
	}

	public Conditions setValQuote(String valQuote) {
		this.valQuote = valQuote;
		return this;
	}

	public Conditions add(String key,Object val,String compareSymbol) {
		if(sb.length()>0)
			sb.append(" and ").append(keyQuote).append(key).append(keyQuote).append(compareSymbol).append(valQuote).append(val).append(valQuote);
		else
			sb.append(keyQuote).append(key).append(keyQuote).append(compareSymbol).append(valQuote).append(val).append(valQuote);
		return this;
	}
	
	public Conditions add(Map<String, Object> map,String compareSymbol) {
		for(Map.Entry<String, Object> e:map.entrySet()){
			if(e.getValue()!=null)
				add(e.getKey(), e.getValue(), compareSymbol);
		}
		return this;
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}
	
	public boolean isEmpty() {
		return sb.length()<1;
	}
}
