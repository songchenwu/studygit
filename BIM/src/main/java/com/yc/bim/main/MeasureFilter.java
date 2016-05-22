package com.yc.bim.main;

import com.yc.bim.exception.BIMExcption;


public interface MeasureFilter <T>{

	boolean doFilter(T t) throws BIMExcption;

}
