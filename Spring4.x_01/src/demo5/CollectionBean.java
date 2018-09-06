package demo5;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/***
 * 集合属性的注入
 */
public class CollectionBean {
	
	private String [] arrs;
	private List<String> list;
	private Set<String> set;

	public String[] getArrs() {
		return arrs;
	}

	public void setArrs(String[] arrs) {
		this.arrs = arrs;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	
	
	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "CollectionBean [arrs=" + Arrays.toString(arrs) + ", list=" + list + ", set=" + set + "]";
	}





	
}
