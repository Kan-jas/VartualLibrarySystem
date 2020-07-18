package Bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CheckoutListBean {
	private Map<Integer, MaterialBean> materials = new HashMap<Integer, MaterialBean>();
	private int total;

		public CheckoutListBean() {

		}

	public Map<Integer, MaterialBean>getMaterials() {
		return materials;
	}

	public void addCheckoutList(MaterialBean materials, int nums) {
		MaterialBean material = (MaterialBean) materials.get(Integer.valueOf(bean.getMaterial_id()));
		if (material == null) {
			bean.setMaterialCheckoutNumber(nums);
			materials.put(Integer.valueOf(bean.getMaterial_id()), bean);
		} else {
			material.setaterialCheckoutNumber(nums + material.getMaterialCheckoutNumber());
		}
		recalcTotal();
	}

	public void deleteCheckoutList(int material_id) {
		materials.remove(Integer.valueOf(material_id));
		recalcTotal();
	}

	public int getTotal() {
		return total;
	}

	private void recalcTotal() {
		total = 0;
		Collection<CheckOutBean> list = materials.values();
		for (CheckoutBean checkout : list) {
			total += material.getMaterialCheckoutNumber();
		}
	}
}
