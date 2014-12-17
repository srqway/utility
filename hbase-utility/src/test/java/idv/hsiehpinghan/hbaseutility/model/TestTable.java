package idv.hsiehpinghan.hbaseutility.model;

import idv.hsiehpinghan.hbaseutility.annotation.HBaseTable;
import idv.hsiehpinghan.hbaseutility.interfaces.ColumnFamily;
import idv.hsiehpinghan.hbaseutility.interfaces.RowKey;

@HBaseTable("TestTbl")
public class TestTable {
	private Key rowKey;
	private ColFam1 colFam_1;
	private ColFam2 colFam_2;

	public TestTable() {
		super();
	}

	public TestTable(Key rowKey, ColFam1 colFam_1, ColFam2 colFam_2) {
		super();
		this.rowKey = rowKey;
		this.colFam_1 = colFam_1;
		this.colFam_2 = colFam_2;
	}

	public Key getRowKey() {
		String id = rowKey.getId();
		int order = rowKey.getOrder();
		// ArrayUtils.addAll(Bytes.toBytes(id), Bytes.toBytes(order))

		return rowKey;
	}

	public void setRowKey(Key rowKey) {
		this.rowKey = rowKey;
	}

	public static class Key implements RowKey {
		private String id;
		private int order;

		public Key() {
			super();
		}

		public Key(String id, int order) {
			super();
			this.id = id;
			this.order = order;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		@Override
		public byte[] toBytes() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static class ColFam1 implements ColumnFamily {
	}

	public static class ColFam2 implements ColumnFamily {
	}
}
