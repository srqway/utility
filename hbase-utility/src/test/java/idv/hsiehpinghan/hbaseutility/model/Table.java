package idv.hsiehpinghan.hbaseutility.model;

import idv.hsiehpinghan.hbaseutility.annotation.ColumnFamily;
import idv.hsiehpinghan.hbaseutility.annotation.RowKey;

@idv.hsiehpinghan.hbaseutility.annotation.Table("TestTable")
public class Table {
	@RowKey
	private Key rowKey;
	@ColumnFamily
	private ColFam1 colFam_1;
	@ColumnFamily
	private ColFam2 colFam_2;

	public Key getRowKey() {
		String id = rowKey.getId();
		int order = rowKey.getOrder();
//		ArrayUtils.addAll(Bytes.toBytes(id), Bytes.toBytes(order))
		
		return rowKey;
	}

	public void setRowKey(Key rowKey) {
		this.rowKey = rowKey;
	}

	public static class Key {
		String id;
		int order;

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

	}

	public static class ColFam1 {
	}

	public static class ColFam2 {
	}
}
