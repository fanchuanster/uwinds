package challenge;

public class IntKeyObject implements Comparable<IntKeyObject> {
	private Object val;
	private Integer key;
	private boolean reverseCompare;
	
	public IntKeyObject(int key, Object val, boolean reverseCompare) {
		this.key = key;
		this.val = val;
		this.reverseCompare = reverseCompare;
	}
	
	public Object getContent() {
		return val;
	}
	public Integer getKey() {
		return key;
	}

	@Override
	public int compareTo(IntKeyObject other) {
		return reverseCompare ? other.getKey().compareTo(this.getKey()) : getKey().compareTo(other.getKey());
	}
	
}