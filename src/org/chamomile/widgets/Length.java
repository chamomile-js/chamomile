package org.chamomile.widgets;

public final class Length {
	private static final String UNIT_MM = "mm";
	private static final String UNIT_CM = "cm";
	private static final String UNIT_IN = "in";
	private static final String UNIT_PC = "pc";
	private static final String UNIT_PT = "pt";
	private static final String UNIT_EX = "ex";
	private static final String UNIT_EM = "em";
	private static final String UNIT_REM = "rem";
	private static final String UNIT_PCT = "%";
	private static final String UNIT_PX = "px";

	public enum Unit {
		PX {
			@Override
			public String getType() {
				return UNIT_PX;
			}
		},
		PCT {
			@Override
			public String getType() {
				return UNIT_PCT;
			}
		},
		EM {
			@Override
			public String getType() {
				return UNIT_EM;
			}
		},
		REM {
			@Override
			public String getType() {
				return UNIT_REM;
			}
		},
		EX {
			@Override
			public String getType() {
				return UNIT_EX;
			}
		},
		PT {
			@Override
			public String getType() {
				return UNIT_PT;
			}
		},
		PC {
			@Override
			public String getType() {
				return UNIT_PC;
			}
		},
		IN {
			@Override
			public String getType() {
				return UNIT_IN;
			}
		},
		CM {
			@Override
			public String getType() {
				return UNIT_CM;
			}
		},
		MM {
			@Override
			public String getType() {
				return UNIT_MM;
			}
		};

		public abstract String getType();
	}

	public static Length px(double value) {
		return new Length(value, Unit.PX);
	}

	public static Length pct(double value) {
		return new Length(value, Unit.PCT);
	}

	public static Length em(double value) {
		return new Length(value, Unit.EM);
	}

	public static Length rem(double value) {
		return new Length(value, Unit.REM);
	}

	public static Length ex(double value) {
		return new Length(value, Unit.EX);
	}

	public static Length pt(double value) {
		return new Length(value, Unit.PT);
	}

	public static Length pc(double value) {
		return new Length(value, Unit.PC);
	}

	public static Length in(double value) {
		return new Length(value, Unit.IN);
	}

	public static Length cm(double value) {
		return new Length(value, Unit.CM);
	}

	public static Length mm(double value) {
		return new Length(value, Unit.MM);
	}

	// ---

	public static final Length AUTO = new Length(0D, null);
	public static final Length ZERO = new Length(0D, Unit.PX);

	private final double value;
	private final Unit unit;

	protected Length(double value, Unit unit) {
		this.value = value;
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	public Unit getUnit() {
		return unit;
	}

	@Override
	public int  hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Length other = (Length) obj;
		if (unit != other.unit)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return unit != null ? (value + unit.getType()) : "auto";
	}
}
