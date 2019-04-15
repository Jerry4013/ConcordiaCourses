package lab.lab11;

@SuppressWarnings("hiding")
public class SerialObject<Long, T> {
	private Long serialnumber;
	private T obj;
	
	
	/**
	 * @param serialnumber
	 * @param obj
	 */
	public SerialObject(Long serialnumber, T obj) {
		super();
		this.serialnumber = serialnumber;
		this.obj = obj;
	}
	public Long getSerialnumber() {
		return serialnumber;
	}
	public T getObj() {
		return obj;
	}
	
	@Override
	public String toString() {
		return "SerialObject [serialnumber=" + serialnumber + ", obj=" + obj + "]";
	}
	
	
	
}
