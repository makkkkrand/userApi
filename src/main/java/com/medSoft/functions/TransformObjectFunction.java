package com.medSoft.functions;

import java.util.function.BiFunction;

import com.google.gson.Gson;

public class TransformObjectFunction<T, R> {

	@SuppressWarnings("unchecked")
	BiFunction<T, R, R> f1 = (a, b) -> {
		Gson gson = new Gson();
		return ((R) gson.fromJson(gson.toJson(a), b.getClass()));
	};

	public BiFunction<T, R, R> getF1() {
		return f1;
	}

	public void setF1(BiFunction<T, R, R> f1) {
		this.f1 = f1;
	}

}
