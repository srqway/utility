package idv.hsiehpinghan.objectutility.object;

import idv.hsiehpinghan.objectutility.interfaces.OuterInterface;

public class OuterObj implements OuterInterface {
	public class InnerObj {
		private OuterObj outer;
		private OuterInterface outerInterface;

		public InnerObj() {
		}

		public InnerObj(OuterObj outer) {
			this.outer = outer;
		}

		public InnerObj(OuterInterface outerInterface) {
			this.outerInterface = outerInterface;
		}

		public OuterObj getOuter() {
			return outer;
		}

		public void setOuter(OuterObj outer) {
			this.outer = outer;
		}

		public OuterInterface getOuterInterface() {
			return outerInterface;
		}

		public void setOuterInterface(OuterInterface outerInterface) {
			this.outerInterface = outerInterface;
		}

	}
}
