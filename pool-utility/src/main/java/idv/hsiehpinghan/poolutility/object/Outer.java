package idv.hsiehpinghan.poolutility.object;

import idv.hsiehpinghan.poolutility.annotation.DoNotReset;

public class Outer {
	private byte _byte;
	private short _short;
	private int _int;
	private long _long;
	private float _float;
	private double _double;
	private char _char;
	private boolean _boolean;
	private Object _Object;
	private Inner inner;
	@DoNotReset
	private Inner doNotResetInner;

	public Outer() {
		super();
	}

	public Outer(byte _byte, short _short, int _int, long _long, float _float,
			double _double, char _char, boolean _boolean, Object _Object,
			Inner inner, Inner doNotResetInner) {
		super();
		this._byte = _byte;
		this._short = _short;
		this._int = _int;
		this._long = _long;
		this._float = _float;
		this._double = _double;
		this._char = _char;
		this._boolean = _boolean;
		this._Object = _Object;
		this.inner = inner;
		this.doNotResetInner = doNotResetInner;
	}

	public byte get_byte() {
		return _byte;
	}

	public void set_byte(byte _byte) {
		this._byte = _byte;
	}

	public short get_short() {
		return _short;
	}

	public void set_short(short _short) {
		this._short = _short;
	}

	public int get_int() {
		return _int;
	}

	public void set_int(int _int) {
		this._int = _int;
	}

	public long get_long() {
		return _long;
	}

	public void set_long(long _long) {
		this._long = _long;
	}

	public float get_float() {
		return _float;
	}

	public void set_float(float _float) {
		this._float = _float;
	}

	public double get_double() {
		return _double;
	}

	public void set_double(double _double) {
		this._double = _double;
	}

	public char get_char() {
		return _char;
	}

	public void set_char(char _char) {
		this._char = _char;
	}

	public boolean is_boolean() {
		return _boolean;
	}

	public void set_boolean(boolean _boolean) {
		this._boolean = _boolean;
	}

	public Object get_Object() {
		return _Object;
	}

	public void set_Object(Object _Object) {
		this._Object = _Object;
	}

	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}

	public Inner getDoNotResetInner() {
		return doNotResetInner;
	}

	public void setDoNotResetInner(Inner doNotResetInner) {
		this.doNotResetInner = doNotResetInner;
	}

	@Override
	public String toString() {
		return "Outer [_byte=" + _byte + ", _short=" + _short + ", _int="
				+ _int + ", _long=" + _long + ", _float=" + _float
				+ ", _double=" + _double + ", _char=" + _char + ", _boolean="
				+ _boolean + ", _Object=" + _Object + ", inner=" + inner
				+ ", doNotResetInner=" + doNotResetInner + "]";
	}
}
