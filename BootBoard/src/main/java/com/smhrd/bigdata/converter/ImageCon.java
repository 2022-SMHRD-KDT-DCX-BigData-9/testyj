package com.smhrd.bigdata.converter;

import java.io.IOException;

public abstract class ImageCon<F,S> {
	public abstract S convert(F f) throws IOException;
}
