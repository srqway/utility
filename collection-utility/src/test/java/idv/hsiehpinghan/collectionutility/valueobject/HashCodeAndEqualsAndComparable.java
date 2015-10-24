package idv.hsiehpinghan.collectionutility.valueobject;

public class HashCodeAndEqualsAndComparable implements
		Comparable<HashCodeAndEqualsAndComparable> {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.compareTo((HashCodeAndEqualsAndComparable) obj) == 0;
	}

	@Override
	public int compareTo(HashCodeAndEqualsAndComparable obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			return 1;
		return Integer.compare(this.getId(), obj.getId());
	}

}
