package idv.hsiehpinghan.objectutility.object;

public class FieldTest {
	private Integer integer = 1;
	private String str = "str---";
	private ReflectionSub sub = new ReflectionSub();
	private InterfaceTest itf = new InterfaceTestImpl();

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public ReflectionSub getSub() {
		return sub;
	}

	public void setSub(ReflectionSub sub) {
		this.sub = sub;
	}

	public InterfaceTest getItf() {
		return itf;
	}

	public void setItf(InterfaceTest itf) {
		this.itf = itf;
	}

}
