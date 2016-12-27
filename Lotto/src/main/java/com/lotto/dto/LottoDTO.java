package com.lotto.dto;

public class LottoDTO {
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;
	private int bonus;
	
	public LottoDTO() {
		super();
	}

	public LottoDTO(int num1, int num2, int num3, int num4, int num5, int num6, int bonus) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		this.num6 = num6;
		this.bonus = bonus;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}

	public int getNum5() {
		return num5;
	}

	public void setNum5(int num5) {
		this.num5 = num5;
	}

	public int getNum6() {
		return num6;
	}

	public void setNum6(int num6) {
		this.num6 = num6;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LottoDTO [num1=");
		builder.append(num1);
		builder.append(", num2=");
		builder.append(num2);
		builder.append(", num3=");
		builder.append(num3);
		builder.append(", num4=");
		builder.append(num4);
		builder.append(", num5=");
		builder.append(num5);
		builder.append(", num6=");
		builder.append(num6);
		builder.append(", bonus=");
		builder.append(bonus);
		builder.append("]");
		return builder.toString();
	}
}
