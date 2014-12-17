package idv.hsiehpinghan.hbaseutility.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;

import idv.hsiehpinghan.datatypeutility.utility.ArrayUtility;
import idv.hsiehpinghan.hbaseutility.annotation.HBaseTable;
import idv.hsiehpinghan.hbaseutility.interfaces.HBaseColumnFamily;
import idv.hsiehpinghan.hbaseutility.interfaces.HBaseQualifier;
import idv.hsiehpinghan.hbaseutility.interfaces.HBaseRowKey;
import idv.hsiehpinghan.hbaseutility.interfaces.HBaseValue;

/**
 * Test table.
 * 
 * @author thank.hsiehpinghan
 *
 */
@HBaseTable("TestTbl")
public class TestTable {
	private Key rowKey;
	private ColFam colFam;

	public TestTable() {
		super();
	}

	public TestTable(Key rowKey, ColFam colFam) {
		super();
		this.rowKey = rowKey;
		this.colFam = colFam;
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

	public ColFam getColFam() {
		return colFam;
	}

	public void setColFam(ColFam colFam) {
		this.colFam = colFam;
	}

	/**
	 * Row key.
	 * 
	 * @author thank.hsiehpinghan
	 *
	 */
	public static class Key implements HBaseRowKey {
		static {
			int idLength = 10;
			int idIndex = 0;
			int orderIndex = idIndex + idLength;
			ID_LENGTH = idLength;
			ID_INDEX = idIndex;
			ORDER_INDEX = orderIndex;
		}
		private static final int ID_LENGTH;
		private static final int ID_INDEX;
		private static final int ORDER_INDEX;
		private String id;
		private int order;
		@Autowired
		private ArrayUtility arrayUtility;

		public Key() {
			super();
		}

		public Key(String id, int order) {
			super();
			this.id = id;
			this.order = order;
		}

		public Key(byte[] rowKey) {
			super();
			this.id = Bytes.toString(ArrayUtils.subarray(rowKey, ID_INDEX, ORDER_INDEX));
//			this.order = Bytes.toInt(ArrayUtils.subarray(rowKey, ORDER_INDEX, rowKey.))
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
			byte[] idArr = Bytes.toBytes(StringUtils.leftPad(id, ID_LENGTH));
			byte[] orderArr = Bytes.toBytes(order);
			byte[] all = arrayUtility.addAll(idArr, orderArr);
			return all;
		}

	}

	/**
	 * Column family.
	 * 
	 * @author thank.hsiehpinghan
	 *
	 */
	public static class ColFam implements HBaseColumnFamily {
		/**
		 * Qualifier.
		 * 
		 * @author thank.hsiehpinghan
		 *
		 */
		public static class TestQualifier1 implements HBaseQualifier {
			private String q;
			private Integer i;

			@Override
			public byte[] toBytes() {
				// TODO Auto-generated method stub
				return null;
			}
		}

		/**
		 * Value.
		 * 
		 * @author thank.hsiehpinghan
		 *
		 */
		public static class TestValue1 implements HBaseValue {
			private BigDecimal v;

			public TestValue1() {
				super();
			}

			public TestValue1(BigDecimal v) {
				super();
				this.v = v;
			}

			@Override
			public byte[] toBytes() {
				return Bytes.toBytes(v);
			}

		}
	}

}
