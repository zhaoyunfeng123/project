package bean;

public class PrivateDishBean {
	private int id;
	private String dishname;
	private String raw;
	private String method;
	private String photo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
	}
	public String getRaw() {
		return raw;
	}
	public void setRaw(String raw) {
		this.raw = raw;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "PrivateDishBean [id=" + id + ", dishname=" + dishname + ", raw=" + raw + ", method=" + method
				+ ", photo=" + photo + "]";
	}
	
}
